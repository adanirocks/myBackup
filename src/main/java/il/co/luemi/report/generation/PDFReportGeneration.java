/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.report.generation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.lang.model.element.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import il.co.luemi.domain.CustomerDetails;
import il.co.luemi.response.CustomerDetailsResponse;

public class PDFReportGeneration {

	/**
	 * The method to Pdf report.
	 *
	 * @param customerDetails the customer details
	 * @throws FileNotFoundException the file not found exception
	 * @throws DocumentException the document exception
	 */
	public static void pdfReport(List<CustomerDetails> customerDetails) throws FileNotFoundException, DocumentException {
		// TODO Auto-generated method stub
		
		String Target= "D:\\Backend\\CustomerDetailsPDF1.pdf";
	
		{
		//Create Document
		Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(Target));
		
		// Open the document
		
		document.open();
		
		//Create a Paragraph
		Paragraph intro = new Paragraph("CustomerDetails Report" );
		Paragraph space = new Paragraph(" ");
		
		//Create Table
		
		PdfPTable table =new PdfPTable(6);
		//PdfPTable table = new PdfPTable(new float[] { 2, 1, 2 });
		  
		
		//Create a cell
		PdfPCell customerId = new PdfPCell(new Paragraph("CUSTOMER ID"));//baseclass.getCustomer
		PdfPCell name = new PdfPCell(new Paragraph("NAME"));
		PdfPCell emailId = new PdfPCell(new Paragraph("EMAIL ID"));
		PdfPCell mobileNo= new PdfPCell(new Paragraph("MOBILE NO"));
		PdfPCell address = new PdfPCell(new Paragraph("ADDRESS"));
		PdfPCell panNo = new PdfPCell(new Paragraph("PAN NO"));
		
		//Add the Cell to the Table
		 table.addCell(customerId);
		 table.addCell(name);
		 table.addCell(emailId);
		 table.addCell(mobileNo);
		 table.addCell(address);
		 table.addCell(panNo);
		//Add Colour
		 table.setHeaderRows(1);
		  PdfPCell[] cells = table.getRow(0).getCells(); 
		  for (int j=0;j<cells.length;j++){
		     cells[j].setBackgroundColor(BaseColor.LIGHT_GRAY);
		  }
		  
		
			
			for (CustomerDetails customerDetails1: customerDetails)
			{
				
				int customerId2 = customerDetails1.getCustomerId();
				customerId= new PdfPCell(new Paragraph(Integer.toString(customerId2)));
				name= new PdfPCell(new Paragraph(customerDetails1.getName()));
				emailId= new PdfPCell(new Paragraph(customerDetails1.getEamilId()));
				mobileNo= new PdfPCell(new Paragraph(customerDetails1.getMobileNo().toString()));
				address= new PdfPCell(new Paragraph(customerDetails1.getAddress()));
				panNo= new PdfPCell(new Paragraph(customerDetails1.getPanNo()));
				
				table.addCell(customerId);
				table.addCell(name);
				table.addCell(emailId);
				table.addCell(mobileNo);
				table.addCell(address);
				table.addCell(panNo);
				
			
			}
				//add object to the Documents
				
				document.add(intro);
				document.add(space);
				document.add(table);
				
				//close the Document
				document.close();
				System.out.println("Report Generated Successfully");
			}
		 
	}


}
