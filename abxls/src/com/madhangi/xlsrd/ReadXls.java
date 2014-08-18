package com.madhangi.xlsrd;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXls {
	
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	Student student = null;

	public boolean readXlsFileAndUpdateDB(FileInputStream inFile, DBInterface dbIf) throws Exception {
		if(null == inFile || null == dbIf) {
			return false;
		}

		int iIterator = 0;
		String strVal = null;
    	Double dVal = null;
    	boolean bSkipRow = false;

		workbook	= new XSSFWorkbook(inFile);
		sheet		= workbook.getSheetAt(0);
		student		= new Student();

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
        	student.clearAll();
        	iIterator = 1;
        	bSkipRow = true;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                    	dVal = cell.getNumericCellValue();
                    	strVal = null;
                        break;
                    case Cell.CELL_TYPE_STRING:
                    	strVal = cell.getStringCellValue();
                    	System.out.println("Last String: "+strVal);
                    	strVal = strVal.trim();
                    	bSkipRow = (null == strVal || strVal.length() <= 0);
                    	bSkipRow = bSkipRow && (1 == iIterator || 2 == iIterator);
                        break;
                }
                if(6 == iIterator && null != strVal && strVal.equalsIgnoreCase("PARTICIPATOR")) {
                	iIterator = 6;
                }
                student.setValue(iIterator, strVal);
                strVal = null;
                iIterator++;
            }
            if(false == bSkipRow && !dbIf.isEntryPresent(student.getIntValue(1))) {
            	dbIf.writeToDB(student);
            }
        }
        return true;
	}
	
	
	public static void main( String[] args ) {
		String driver = "com.mysql.jdbc.Driver";
		try {
			//	Load the SQL drivers
			Class.forName(driver).newInstance();

			//FileInputStream inFile = new FileInputStream(new File("/home/sangar/proj/Madhangi/madhangiweb/sample.xlsx"));
			FileInputStream inFile = new FileInputStream(new File("input/handwriting_final_03.xlsx"));
			ReadXls rdXls = new ReadXls();
			DBInterface dbIf = new DBInterface();

			dbIf.prepareForWrite();
			rdXls.readXlsFileAndUpdateDB(inFile, dbIf);

			dbIf.closeWriting();
			dbIf.closeDB();
			inFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
