package Courtier;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Mohamed
 */
public class pdfGeneration {

    public void addpdf(String xx) throws FileNotFoundException, DocumentException {

        Document document = new Document() {
        };
        PdfWriter.getInstance(document, new FileOutputStream(new File("./demo.pdf")));
        document.open();
        // document.addTitle("voila");
        document.add(new Paragraph(xx));

        document.close();
    }
    public static void main(String[] args) {
        
    }
}
