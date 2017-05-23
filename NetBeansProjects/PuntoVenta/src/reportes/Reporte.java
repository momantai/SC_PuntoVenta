/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;
import com.lowagie.text.DocumentException;
import java.awt.Desktop;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.xhtmlrenderer.pdf.ITextRenderer;
/**
 *
 * @author awelo
 */
public class Reporte {
    public void escribirArchivo(String nombreArchivo, ResultSet obte){
        File fil= new File(nombreArchivo+".xhtml");
        
        
        try{
            FileWriter escritor= new FileWriter(fil);
            BufferedWriter bufer = new BufferedWriter(escritor);
            PrintWriter vista = new PrintWriter(bufer);
            vista.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
            vista.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"es\" xml:lang=\"es\">");
            vista.append("<head>");
            vista.append("<title>"+nombreArchivo+"</title>");
            vista.append("</head>");
            vista.append("<body>");
            vista.append("<center>");
            vista.append("<table>");
            vista.append("<tr>");
            vista.append("<th>Codigo</th>");
            vista.append("<th>Descripcion</th>");
            vista.append("<th>Existencia</th>");
            vista.append("<th>Costo</th>");
            vista.append("</tr>");
            while(obte.next()){
                vista.append("<tr>");
                vista.append("<td>"+obte.getString(1)+"</td>");
                vista.append("<td>"+obte.getString(2)+"</td>");
                vista.append("<td>"+obte.getString(3)+"</td>");
                vista.append("<td>"+obte.getString(4)+"</td>");
                vista.append("</tr>");
            }
            vista.append("</table>");
            vista.append("</center>");
            vista.append("</body>");
            vista.append("</html>");
            vista.close();
            escritor.close();
            
        } catch(IOException e){
            System.out.println("Error al cargar el reporte "+e);
        } catch(SQLException e){
            System.out.println("Error al cargar el reporte "+e);
        }
    }
    
    public void conevertirPdf(String nombreArchivo){
        try{
            File inputFile= new File(nombreArchivo+".xhtml");
            OutputStream out = new FileOutputStream(new File(nombreArchivo+"_apdf.pdf"));
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(inputFile);
            renderer.layout();
            renderer.createPDF(out);
            out.close();
            abrirArchivo(nombreArchivo+"_apdf.pdf");
        } catch(IOException | DocumentException e){
            System.out.println("Error al cargar "+e);
        }
    }
    
    private void abrirArchivo(String archivo){
        try {
            File path = new File(archivo);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
