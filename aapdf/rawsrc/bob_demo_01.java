package com.madhangi.bob.hwcontest;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.net.URL;

public class GTest1 {
  public static void main(String[] args) {
	  if(3 != args.length) {
		  System.out.println("-------------------------Madhangi Hall Ticker Generator 2.0-------------------");
		  System.out.println("Usage: java -jar MadhangiHTGen StartingRollNumber NumberOfCopies CopiesPerPage");
		  System.out.println("Example: java -jar MadhangiHTGenDemo.jar 1001 60 6");
		  System.out.println("Tips: Increase or decrease the CopiesPerPage to get a proper pdf");
		  System.out.println("Warning: This program will crash if HallTicket.pdf is already opened.");
		  System.out.println("So close HallTicket.pdf before running this program.");
		  System.out.println("--------------------------------------------------------------------------------");
		  System.out.println();
		  return;
	  } else {
		  System.out.println("-------------------------Madhangi Hall Ticker Generator 2.0-------------------");
		  System.out.println();
	  }

	  int iRollNo = Integer.parseInt(args[0]);
	  int iCopies = Integer.parseInt(args[1]);
	  int iCopiesPerPage = Integer.parseInt(args[2]);
	  int iLoop = 0;
	  
	  Document document = new Document();
    document.setPageSize(PageSize.A4);
    document.setMargins(0, 0, 0, 0);
    try {
        PdfWriter.getInstance(document, new FileOutputStream("HallTicket.pdf"));
        document.open();


        //Image image1 = Image.getInstance("OurLogo_02.jpg");
        Image image1 = Image.getInstance("BobLogo_02.jpg");
        int indentation = 0;
        float scaler = 67;//((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - indentation) / image1.getWidth()) * 100;
        image1.scalePercent(scaler);
        
        for(iLoop = 1; iLoop <= iCopies; iLoop++, iRollNo++) {
        	document.add(image1);
        	Paragraph paragraph = new Paragraph();
        	//paragraph.setIndentationLeft(130);
        	String strRollNumber = "     Demo version by www.madhangi.com. Roll number: "+iRollNo+"                                   "+
					"Roll number: " +iRollNo;
        	/*String strRollNumber = "Roll number: "+iRollNo+"                                                                   "+
        							"Roll number: " +iRollNo;*/
        	//paragraph.add("Your roll number: 1001                                                               Roll number: 1001");
        	paragraph.add(strRollNumber);
        	document.add(paragraph);
        	document.add(new Phrase("\n"));
        	if(0 == (iLoop % iCopiesPerPage))
        		document.newPage();
        	if(20 <= iLoop) {
        		break;
        	}
        }

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("As it is a demo version, it is restricting the PDF to a few pages.");
		System.out.println("For full version, please call 99 401 301 35.");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("");
       
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
}
