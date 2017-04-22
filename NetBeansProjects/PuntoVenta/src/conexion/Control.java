
package conexion;
import com.mysql.jdbc.Connection;
import entidades.Productos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author momantai
 */
public class Control  extends Conexion{

    private PreparedStatement stmt;
    public byte registrarProductos(Productos producto){
        int a = producto.getCodigo();
        String b = producto.getDescripcion();
        int c = producto.getClasificacion();
        float d = producto.getPrecio();
        int e = producto.getActivo();
        String f = producto.getImagen();
        byte exito=0;
        
        try {
            Connection con;
            con = conectar();
            stmt = con.prepareStatement("INSERT INTO productos VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, a);
            stmt.setString(2, b);
            stmt.setInt(3, c);
            stmt.setFloat(4, d);
            stmt.setInt(5, e);
            stmt.setString(6, f);
            
            stmt.executeUpdate();
            exito=1;
        } catch(SQLException eE) {
            System.out.println("" + eE);
        }
        return exito;
    }
}
