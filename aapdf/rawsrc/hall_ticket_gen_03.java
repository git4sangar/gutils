
//GN - student's copy
package com.madhangi.bob.hwcontest;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GTest1 {
  public static void main(String[] args) {
	  if(3 != args.length) {
		  System.out.println("-------------------------Madhangi Hall Ticker Generator 3.0-------------------");
		  System.out.println("Usage: java -jar MadhangiHTGen StartingRollNumber NumberOfCopies CopiesPerPage");
		  System.out.println("Example: java -jar MadhangiHTGenDemo.jar 1001 50 5");
		  System.out.println("Tips: Increase or decrease the CopiesPerPage to get a proper pdf");
		  System.out.println("Warning: This program will crash if HallTicket.pdf is already opened.");
		  System.out.println("So close HallTicket.pdf before running this program.");
		  System.out.println("--------------------------------------------------------------------------------");
		  System.out.println();
		  return;
	  } else {
		  System.out.println("-------------------------Madhangi Hall Ticker Generator 3.0-------------------");
		  System.out.println();
	  }

	  int iRollNo = Integer.parseInt(args[0]);
	  int iCopies = Integer.parseInt(args[1]);
	  int iCopiesPerPage = Integer.parseInt(args[2]);
	  int iNoOfPages = iCopies % iCopiesPerPage;
	  if(0 != iNoOfPages) {
		  iCopies = iCopies + (iCopiesPerPage - iNoOfPages);
	  }
	  iNoOfPages = iCopies / iCopiesPerPage;
	  int iLoop = 0;
	  
	Document document = new Document();
    document.setPageSize(PageSize.A4);
    document.setMargins(0, 0, 0, 0);
    try {
    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HallTicket.pdf"));
        document.open();


        Image image1 = Image.getInstance("OurLogo_03.jpg");
        //Image image1 = Image.getInstance("BobLogo_02.jpg");
        //int indentation = 0;
        //float scaler = 96;//((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - indentation) / image1.getWidth()) * 100;
        float scaler = 67;
        image1.scalePercent(scaler);
        image1.setAlignment(Image.MIDDLE);
        int iRunningNo = iRollNo;
        for(iLoop = 1; iLoop <= iCopies; iLoop++) {
        	document.add(image1);
        	Paragraph paragraph = new Paragraph();
        	paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        	//paragraph.setIndentationLeft(175);
        	String strRollNumber = "Roll number: "+iRunningNo;
        	//+ "                                                                   "+"Roll number: " +iRunningNo;
        	//paragraph.add("Your roll number: 1001                                                               Roll number: 1001");
        	paragraph.add(strRollNumber);
        	document.add(paragraph);
        	document.add(new Phrase("\n"));
        	if(0 == (iLoop % iCopiesPerPage)) {
        		document.newPage();
        		iRunningNo = ++iRollNo;
        		//absText(writer, "Guru Sample", 10, 10);
        	} else {
        		iRunningNo+=iNoOfPages;
        	}
        }

     
        /*String imageUrl = "http://jenkov.com/images/" + "20081123-20081123-3E1W7902-small-portrait.jpg";
        Image image2 = Image.getInstance(new URL(imageUrl));
        document.add(image2);*/

        document.close();
        System.out.println();
        System.out.println("Successfully created HallTicket.pdf");
        System.out.println();
        System.out.println();
    } catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public static void absText(PdfWriter writer, String text, int x, int y) {
	    try {
	      PdfContentByte cb = writer.getDirectContent();
	      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	      cb.saveState();
	      cb.beginText();
	      cb.moveText(x, y);
	      cb.setFontAndSize(bf, 12);
	      cb.showText(text);
	      //cb.showTextAligned(Element.ALIGN_RIGHT, text, 400, 752, 0);
	      cb.endText();
	      cb.restoreState();
	    } catch (DocumentException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
  
}

