/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author HP
 */
public class pdfGeneration {
    public void addpdf(String xx) throws FileNotFoundException, DocumentException{
        
     Document document= new Document();
     PdfWriter.getInstance(document, new FileOutputStream(new File("./demo.pdf")));
     document.open();
    // document.addTitle("voila");
     document.add(new Paragraph(xx));
    
     document.close();
    }
            
}
