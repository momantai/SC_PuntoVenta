
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
    
    public byte modificarProductos(Productos producto){
        String sql = "UPDATE productos SET descripcion=?, clasificacion=?, precio=?, activo=?, imagen=? WHERE idCodigo="+producto.getCodigo();
        byte exito=0;
        try{
            stmt = conectar().prepareStatement(sql);
            stmt.setString(1, producto.getDescripcion());
            stmt.setInt(2, producto.getClasificacion());
            stmt.setFloat(3, producto.getPrecio());
            stmt.setInt(4, producto.getActivo());
            stmt.setString(5, producto.getImagen());
            
            stmt.executeQuery();
            exito=1;
        } catch(SQLException e){
            System.out.println("Error al cargar "+e);
        }
        return exito;
    }
    
    public byte borrarProducto(String dato){
        byte exito=0;
        try{
            stmt = conectar().prepareStatement("DELETE FROM productos WHERE idProducto="+dato);
            stmt.execute();
            exito=1;
        } catch(SQLException e){
            System.out.println("Error al conectar "+e);
        }
        return exito;
    }
}
