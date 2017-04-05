
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
    public void registrarProductos(Productos producto){
        int a = producto.getCodigo();
        String b = producto.getDescripcion();
        int c = producto.getClasificacion();
        float d = producto.getPrecio();
        int e = producto.getActivo();
        
        try {
            Connection con;
            con = conectar();
            stmt = con.prepareStatement("INSER INTO productos VALUES(?, ?, ?, ?, ?)");
            stmt.setInt(1, a);
            stmt.setString(2, b);
            stmt.setInt(3, c);
            stmt.setFloat(4, d);
            stmt.setInt(5, e);
            
            stmt.executeUpdate();
            
        } catch(SQLException eE) {
            System.out.println("" + eE);
        }
    }
}
