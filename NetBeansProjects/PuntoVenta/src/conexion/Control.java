
package conexion;
import com.mysql.jdbc.Connection;
import entidades.Domicilio;
import entidades.Empleado;
import entidades.Productos;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "UPDATE productos SET descripcion=?, clasificacion=?, precio=?, activo=? WHERE idCodigo="+producto.getCodigo();
        byte exito=0;
        try{
            stmt = conectar().prepareStatement(sql);
            stmt.setString(1, producto.getDescripcion());
            stmt.setInt(2, producto.getClasificacion());
            stmt.setFloat(3, producto.getPrecio());
            stmt.setInt(4, producto.getActivo());
            
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
    
    public byte nuevoEmpleado(Domicilio domicilio, Empleado empleado, Usuario usuario){
        byte exito=0;
        try{
            System.out.println("Desde aqui");
            String sql="INSERT INTO users VALUES(0,?,?,?)";
            stmt=conectar().prepareStatement(sql);
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getPermisos());
            if(stmt.executeUpdate()==1){
                System.out.println("usuario bien");
                sql="INSERT INTO domicilio VALUES(0,?,?,?,?)";
                stmt=conectar().prepareStatement(sql);
                stmt.setString(1, domicilio.getCalle());
                stmt.setString(2, domicilio.getNumExt());
                stmt.setString(3, domicilio.getNumInt());
                stmt.setString(4, domicilio.getColonia());
                if(stmt.executeUpdate()==1){
                    System.out.println("domicilio bien");
                    sql="INSERT INTO empleado VALUES(0,?,?,?,?,?,(SELECT MAX(idUser) FROM users), (SELECT MAX(idDomicilio) FROM domicilio))";
                    stmt=conectar().prepareStatement(sql);
                    stmt.setString(1, empleado.getNombre());
                    stmt.setString(2, empleado.getApellidos());
                    stmt.setInt(3,empleado.getEdad());
                    stmt.setString(4, empleado.getPuesto());
                    stmt.setString(5, empleado.getTelefono());
                    if(stmt.executeUpdate()==1){
                        exito=1;
                        System.out.println("empleado bien");
                    }
                }
            }
        } catch(SQLException e){
            System.out.println("Error en la conexion");
        }
        return exito;
    }
    
    public ResultSet empleadoFilt(String dato){
        ResultSet obtener= null;
        try{
            String sql="SELECT nombreE, apellidosE, edad, telefono, users.idUser, users.user, password, permisos, domicilio.idDomicilio, calle, numero, numeroInt, colonia FROM empleado INNER JOIN users ON empleado.user=users.idUser INNER JOIN domicilio ON empleado.domicilioE=domicilio.idDomicilio WHERE idEmpleado="+dato;
            Statement stat=conectar().createStatement();
            obtener=stat.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error al cargar "+e);
        }
        return obtener;
    }
    
    public byte modificarEmpleado(String idDom, Domicilio domicilio, String idUsu, Usuario usuario, String idEmp, Empleado empleado){
        byte exito=0;
        try{
            System.out.println("Desde aqui");
            String sql="UPDATE users SET user=?, password=?, permisos=? WHERE idUser="+idUsu;
            stmt=conectar().prepareStatement(sql);
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getPermisos());
            if(stmt.executeUpdate()==1){
                System.out.println("usuario bien");
                sql="UPDATE domicilio SET calle=?, numero=?, numeroInt=?, colonia=? WHERE idDomicilio="+idDom;
                stmt=conectar().prepareStatement(sql);
                stmt.setString(1, domicilio.getCalle());
                stmt.setString(2, domicilio.getNumExt());
                stmt.setString(3, domicilio.getNumInt());
                stmt.setString(4, domicilio.getColonia());
                if(stmt.executeUpdate()==1){
                    System.out.println("domicilio bien");
                    sql="UPDATE empleado SET nombreE=?, apellidosE=?, edad=?, puesto=?, telefono=? WHERE idEmpleado="+idEmp;
                    stmt=conectar().prepareStatement(sql);
                    stmt.setString(1, empleado.getNombre());
                    stmt.setString(2, empleado.getApellidos());
                    stmt.setInt(3,empleado.getEdad());
                    stmt.setString(4, empleado.getPuesto());
                    stmt.setString(5, empleado.getTelefono());
                    if(stmt.executeUpdate()==1){
                        exito=1;
                        System.out.println("empleado bien");
                    }
                }
            }
        } catch(SQLException e){
            System.out.println("Error en la conexion");
        }
        return exito;
    }
    
    public byte borrarEmpleado(String dato){
        byte exito=0;
        try{
            String sql="SELECT users.idUSer, domicilio.idDomicilio FROM empleado INNER JOIN users ON empleado.user=users.idUser INNER JOIN domicilio ON empleado.domicilioE=domicilio.idDomicilio WHERE idEmpleado="+dato;
            Statement stat= conectar().createStatement();
            ResultSet obtener=stat.executeQuery(sql);
            String[] ids = new String[2];
            while(obtener.next()){
                ids[0]=obtener.getString(1);
                ids[1]=obtener.getString(2);
            }
            
            sql="DELETE FROM users WHERE idUser="+ids[0];
            stmt= conectar().prepareStatement(sql);
            if(stmt.executeUpdate()==1){
                System.out.println("user bien");
                sql="DELETE FROM domicilio WHERE idDomicilio="+ids[1];
                stmt=conectar().prepareStatement(sql);
                if(stmt.executeUpdate()==1){
                    System.out.println("domicilio bien");
                    sql="DELETE FROM empleado WHERE idEmpleado="+dato;
                    stmt= conectar().prepareStatement(sql);
                    if(stmt.executeUpdate()==1){
                        exito=1;
                    }
                }
            }
            
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
}
