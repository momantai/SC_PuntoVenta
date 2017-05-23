

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.license.LicenseKey;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.XfaForm;
import com.itextpdf.tool.xml.xtra.xfa.XFAFlattener;

public class FillAndFlatten {
    /**
     * Manipulates a PDF file src with the file dest as result
     * @param src the original PDF
     * @param xml the XML data that needs to be added to the XFA form
     * @param dest the resulting PDF
     * @throws IOException
     * @throws DocumentException
     * @throws InterruptedException 
     */
    public void manipulatePdf(String src, String xml, File dest)
        throws IOException, DocumentException, InterruptedException {
        System.out.println("Manipulating the form");
    	
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, baos);
        AcroFields form = stamper.getAcroFields();
        XfaForm xfa = form.getXfa();
        xfa.fillXfaForm(new FileInputStream(xml));
        stamper.close();
        
        System.out.println("The form is filled");
        
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        XFAFlattener xfaf = new XFAFlattener(document, writer);
        xfaf.flatten(new PdfReader(baos.toByteArray()));
        document.close();
        
        System.out.println("The form is flattened");
    }
    
    public static void main(String[] args) throws IOException, DocumentException, InterruptedException {
		LicenseKey.loadLicenseFile("itextkey.xml");
		FillAndFlatten app = new FillAndFlatten();
    	app.manipulatePdf("xfa_form.pdf", "xfa_data.xml", new File("xfa_flattened.pdf"));
    	System.exit(0);
    }
}
