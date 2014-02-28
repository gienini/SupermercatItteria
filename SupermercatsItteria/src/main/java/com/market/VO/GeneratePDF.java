package com.market.VO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF extends JFrame{

	public GeneratePDF() {
	}

	public boolean getPDF(Sessio sessio) {

		Map<Producte, Integer> carrito = new HashMap<Producte, Integer>();
		carrito = sessio.getCarrito();

		try {
			JFileChooser jF1= new JFileChooser(); 
			jF1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			FileFilter filtro = new FileNameExtensionFilter("Archivo PDF(.pdf)", "pdf");
			jF1.setFileFilter(filtro);
			this.requestFocus();
			int returnVal = jF1.showSaveDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			OutputStream file= new FileOutputStream (jF1.getSelectedFile()+"\\comanda.pdf");
			//OutputStream file = new FileOutputStream(new File("C:\\Users\\Alumno15\\Downloads\\comanda.pdf"));
			
			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph("Supermercat itteria"));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Senyor/a "+sessio.getNick()));
			document.add(new Paragraph(" "));
			PdfPTable miTabla = new PdfPTable(4);

			PdfPCell celda = new PdfPCell(new Paragraph("Producte",
					FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK)));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(12.0f);
			celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
			miTabla.addCell(celda);

			PdfPCell celda2 = new PdfPCell(new Paragraph("Preu",
					FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK)));
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setPadding(12.0f);
			celda2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			miTabla.addCell(celda2);

			PdfPCell celda3 = new PdfPCell(new Paragraph("Quantitat",
					FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK)));
			celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda3.setPadding(12.0f);
			celda3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			miTabla.addCell(celda3);
			
			PdfPCell celda4 = new PdfPCell(new Paragraph("Cost",
					FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK)));
			celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda4.setPadding(12.0f);
			celda4.setBackgroundColor(BaseColor.LIGHT_GRAY);
			miTabla.addCell(celda4);
			
			int Total=0;
			Iterator<Producte> ite = carrito.keySet().iterator();
			while (ite.hasNext()) {
				Producte key = ite.next();
				miTabla.addCell(key.getNom());
				miTabla.addCell(key.getPreu() + "€");
				miTabla.addCell(carrito.get(key) + " ");
				miTabla.addCell(key.getPreu()*carrito.get(key)+"€") ;
				Total+=key.getPreu()*carrito.get(key);
			}

			miTabla.addCell(" ");
			miTabla.addCell(" ");
			miTabla.addCell("Total:");
			miTabla.addCell(Total+ "€");
			
			document.add(miTabla); // se agrega la tabla al documento miPdf.

			document.add(new Paragraph());

			document.close();
			file.close();
			return true;
			}else{return false;}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	}

}