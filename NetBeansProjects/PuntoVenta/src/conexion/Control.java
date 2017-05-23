
package conexion;
import com.mysql.jdbc.Connection;
import entidades.Domicilio;
import entidades.Empleado;
import entidades.Productos;
import entidades.Proveedor;
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
    public byte registrarProductos(Productos producto, String paquete){
        int a = producto.getCodigo();
        String b = producto.getDescripcion();
        int c = producto.getClasificacion();
        float d = producto.getPrecio();
        int e = producto.getActivo();
        int f = producto.getCantidad();
        String g = producto.getRef();
        byte exito=0;
        try {
            Connection con;
            con = conectar();
            if(paquete.equals("")){
                stmt = con.prepareStatement("INSERT INTO productos VALUES(0,?, ?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, a);
                stmt.setString(2, b);
                stmt.setInt(3, c);
                stmt.setFloat(4, d);
                stmt.setInt(5, e);
                stmt.setInt(6, f);
                stmt.setInt(7, Integer.parseInt(g));
                if(stmt.executeUpdate()==1){
                    stmt = con.prepareStatement("INSERT INTO inventario VALUES(0,?,?,0,0)");
                    stmt.setInt(1, a);
                    stmt.setString(2, b);
                    if(stmt.executeUpdate()==1){
                        exito=1;
                    }
                }
            }else{
                stmt = con.prepareStatement("INSERT INTO productos VALUES(0,?, ?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, a);
                stmt.setString(2, b);
                stmt.setInt(3, c);
                stmt.setFloat(4, d);
                stmt.setInt(5, e);
                stmt.setInt(6, f);
                stmt.setInt(7, Integer.parseInt(g));
                if(stmt.executeUpdate()==1){
                    exito=1;
                }
            }
        } catch(SQLException eE) {
            System.out.println("" + eE);
        }
        return exito;
    }
    
    public byte modificarProductos(Productos producto, String paquete){
        byte exito=0;
        try{
            if(paquete.equals("")){
                String sql = "UPDATE productos SET descripcion=?, clasificacion=?, precio=?, activo=?, cantidad=?, refProd=? WHERE codigoPro="+producto.getCodigo();
                stmt = conectar().prepareStatement(sql);
                stmt.setString(1, producto.getDescripcion());
                stmt.setInt(2, producto.getClasificacion());
                stmt.setFloat(3, producto.getPrecio());
                stmt.setInt(4, producto.getActivo());
                stmt.setInt(5, producto.getCantidad());
                stmt.setInt(6, Integer.parseInt(producto.getRef()));
                if(stmt.executeUpdate()==1){
                    sql="UPDATE inventario SET descripcion=? WHERE codigo="+producto.getCodigo();
                    stmt= conectar().prepareStatement(sql);
                    stmt.setString(1, producto.getDescripcion());
                    exito=1;
                }
            }else{
                String sql = "UPDATE productos SET descripcion=?, clasificacion=?, precio=?, activo=?, cantidad=?, refProd=? WHERE codigoPro="+producto.getCodigo();
                stmt = conectar().prepareStatement(sql);
                stmt.setString(1, producto.getDescripcion());
                stmt.setInt(2, producto.getClasificacion());
                stmt.setFloat(3, producto.getPrecio());
                stmt.setInt(4, producto.getActivo());
                stmt.setInt(5, producto.getCantidad());
                stmt.setInt(6, Integer.parseInt(producto.getRef()));
                if(stmt.executeUpdate()==1){
                    exito=1;
                }
            }
        } catch(SQLException e){
            System.out.println("Error al cargar "+e);
        }
        return exito;
    }
    
    public byte borrarProducto(String dato, int paquete){
        byte exito=0;
        try{
            if(paquete==1){
                stmt = conectar().prepareStatement("DELETE FROM productos WHERE codigoPro="+dato);
                if(stmt.execute()){
                    stmt=conectar().prepareStatement("DELETE FROM productos WHERE codigo="+dato);
                    if(stmt.execute()){
                        exito=1;
                    }
                }
            }else{
                stmt = conectar().prepareStatement("DELETE FROM productos WHERE codigoPro="+dato);
                if(stmt.execute()){
                    exito=1;
                }
            }
        } catch(SQLException e){
            System.out.println("Error al conectar "+e);
        }
        return exito;
    }
    
    public byte nuevoEmpleado(Domicilio domicilio, Empleado empleado, Usuario usuario){
        byte exito=0;
        try{
            System.out.println("Desde aqui");
            String sql="INSERT INTO users VALUES(0,?,?,?,1)";
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
    public byte agregarClasificacion(String clasificacion){
        byte exito=0;
        try{
            String sql="INSERT INTO clasificaion VALUES(0,?)";
            PreparedStatement stat=conectar().prepareStatement(sql);
            stat.setString(1, clasificacion);
            if(stat.executeUpdate()==1){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
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
    public byte desactivarEmpleado(String dato){
        byte exito=0;
        try{
            String sql="SELECT users.idUSer FROM empleado INNER JOIN users ON empleado.user=users.idUser WHERE idEmpleado="+dato;
            Statement stat= conectar().createStatement();
            ResultSet obtener=stat.executeQuery(sql);
            String ids="";
            while(obtener.next()){
                ids=obtener.getString(1);
            }
            sql="UPDATE users SET activo=0 WHERE idUser="+ids;
            stmt=conectar().prepareStatement(sql);
            if(stmt.executeUpdate()==1){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
    public byte activarEmpleado(String dato){
        byte exito=0;
        try{
            String sql="SELECT users.idUSer FROM empleado INNER JOIN users ON empleado.user=users.idUser WHERE idEmpleado="+dato;
            Statement stat= conectar().createStatement();
            ResultSet obtener=stat.executeQuery(sql);
            String ids="";
            while(obtener.next()){
                ids=obtener.getString(1);
            }
            sql="UPDATE users SET activo=1 WHERE idUser="+ids;
            stmt=conectar().prepareStatement(sql);
            if(stmt.executeUpdate()==1){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
    
    public ResultSet mostrarInventario(){
        ResultSet obt=null;
        try{
            String sql="SELECT codigo, descripcionIn, existencia, costo FROM inventario";
            Statement stat = conectar().createStatement();
            obt=stat.executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obt;
    }
    
    public ResultSet mostrarInventFilt(String dato){
        ResultSet obt= null;
        try{
            String sql="SELECT codigo, descripcionIn, existencia, costo FROM inventario WHERE codigo="+dato;
            Statement stat = conectar().createStatement();
            obt=stat.executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obt;
    }
    
    public byte actualizarInventario(String dato, int suma, float costo){
        byte exito=0;
        try{
            String sql="UPDATE inventario SET existencia=?, costo=? WHERE codigo="+dato;
            PreparedStatement stat= conectar().prepareStatement(sql);
            stat.setInt(1, suma);
            stat.setFloat(2, costo);
            if(stat.executeUpdate()==1){
                exito=1;
            }
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
    
    public ResultSet mostrarProveedores(){
        ResultSet obt=null;
        try{
            String sql="SELECT * FROM proveedores";
            Statement stat= conectar().createStatement();
            obt=stat.executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obt;
    }
    
    public ResultSet mostrarProveedorFil(String dato){
            ResultSet obt=null;
        try{
            String sql="SELECT nombreEmpresa, rfcEmpresa, telefono FROM proveedores WHERE nEmpresa="+dato;
            Statement stat= conectar().createStatement();
            obt=stat.executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obt;
    }
    
    public byte agregarProveedor(Proveedor prove){
        byte exito=0;
        try{
            String sql="INSERT INTO proveedores VALUES(0,?,?,?)";
            PreparedStatement stat = conectar().prepareStatement(sql);
            stat.setString(1, prove.getNombreEmpresa());
            stat.setString(2, prove.getRfc());
            stat.setString(3, prove.getTelefono());
            if(stat.executeUpdate()==1){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
    
    public byte modificarProveedor(Proveedor prove, String dato){
        byte exito=0;
        try{
            String sql="UPDATE proveedores SET nombreEmpresa=?, rfcEmpresa=?, telefono=? WHERE nEmpresa="+dato;
            PreparedStatement stat = conectar().prepareStatement(sql);
            stat.setString(1, prove.getNombreEmpresa());
            stat.setString(2, prove.getRfc());
            stat.setString(3, prove.getTelefono());
            if(stat.executeUpdate()==1){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
    
    public byte eliminarProve(String dato){
        byte exito=0;
        try{
            String sql="UPDATE proveedores SET activoProv=0 WHERE nEmpresa="+dato;
            PreparedStatement stat = conectar().prepareStatement(sql);
            if(stat.executeUpdate()==1){
                exito=1;
            }
        }catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return exito;
    }
    
    public ResultSet mostrarCompras(){
        ResultSet obt=null;
        try{
            String sql="SELECT idCompra, monto, proveedores.nombreEmpresa, fecha, hora FROM compras INNER JOIN proveedores ON compras.proveedor=proveedores.nEmpresa";
            Statement stat = conectar().createStatement();
            obt = stat.executeQuery(sql);
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obt;
    }
}
