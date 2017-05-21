/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import entidades.Login;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author momantai
 */
public class Conexion {
    //private final String user = "streetcode";
    //private final String password = "somosinco";
    //private final String url = "jdbc:mysql://db4free.net:3306/streetcode_java";
    
    //private final String user = "root";
    //private final String password = "momantai";
    //private final String url = "jdbc:mysql://localhost:3306/PruebaBD";
    
    private final String user = "133991"; //usuario base de datos
    private final String password = "momantai";//contraseña base de datos
    private final String url = "jdbc:mysql://mysql2.paris1.alwaysdata.com:3306/momantaiter_streetcode";//url base de datos
    
    private Connection con = null;
    
    public Connection conectar(){//Metodo para conectar a la base de datos.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection)DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto correctamente");
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        return con;
    }
    /*Se recibe como parametro el objeto "credenciales" que tiene las variables
    de la clase Login*/
    public int[] validar(Login login){
        ResultSet obtener = null;
        
        /*Se recuperan los datos de las variables de la clase Login*/
        String ID = login.getID();
        String contra = login.getPassword();
        int[] valido={0,0,0};
        
        try{//Se hace la consulta de el usuario y la contraseña en la base de datos
            System.out.println("salto");
            String sql = "SELECT * FROM users WHERE user = '" + ID + "' AND password = '"+ contra +"';";
            con=conectar();//Se conecta a la base de datos
            Statement statement= con.createStatement();
            
            /*Se utiliza ResultSet para acceder a los datos de las columnas y filas de la base de datos.
            Se crea un ubjeto llamado "result"*/
            ResultSet result= (ResultSet) statement.executeQuery(sql);
            
            if(result.next()){
                /*Se extrae el dato de la columna "permisos"*/
                valido[0] = result.getInt("permisos");//el dato que se extrajo se iguala a la variable valido
                valido[1] = result.getInt("idUser");
                valido[2] = result.getInt("activo");
            }
            System.out.println("Se conecto correctamente");
        } catch(Exception e){
            System.out.println("Error en la conexion aqui " + e);
        }
        return valido;//Se retorna la variable "valido" con el respectivo valor que se igualo
    }
     
    /*
        Metodo para hacer la conexion llenar la tabla de productos
    */
    public ResultSet datosProductos(){
        ResultSet obtener = null;
        
        try{
            System.out.println("salto");
            String sql = "SELECT idProducto, descripcion, clasificacion.clasificacion, precio, activo FROM productos INNER JOIN clasificacion ON productos.clasificacion=clasificacion.idClasificacion";
            Statement statement = conectar().createStatement();    
            obtener=(ResultSet) statement.executeQuery(sql);
        
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    /*
        Metodo para llenar la tabla con filtro
    */
    public ResultSet datosProductosFilt(String dato){
        ResultSet obtener=null;
        
        try{
            System.out.println("salto");
            String sql = "SELECT idProducto, descripcion, clasificacion.clasificacion, precio, activo FROM productos INNER JOIN clasificacion ON productos.clasificacion=clasificacion.idClasificacion WHERE idProducto  LIKE '"+dato+"%' OR descripcion LIKE '%"+dato+"%'";
            
            Statement statement = con.createStatement();
            obtener=(ResultSet) statement.executeQuery(sql);
        
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    public ResultSet darUnValor(String dato){
        ResultSet obtener=null;
        
        try{
            System.out.println("salto");
            String sql = "SELECT descripcion, clasificacion, precio, activo FROM productos WHERE idProducto="+dato;
            
            Statement statement = con.createStatement();
            obtener=(ResultSet) statement.executeQuery(sql);
        
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    /*
        Metodo para llenar el combobox de clasificaciones
    */
    public ResultSet datosClasificacion(){
        ResultSet obtener = null;
        
        try{
            System.out.println("salto");
            String sql = "SELECT clasificacion FROM clasificacion";
            Statement statement = conectar().createStatement();
            obtener=(ResultSet) statement.executeQuery(sql);
            System.out.println("chido");
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
    
    public ResultSet mostrarEmpleados(int cond){
        ResultSet obtener=null;
        
        try{
            System.out.println("Salto");
            String sql="";
            if(cond==0){
                sql = "SELECT idEmpleado, nombreE, apellidosE, users.user, permisos, activo, domicilio.calle, numero, numeroInt, colonia FROM empleado INNER JOIN users ON empleado.user=users.idUser INNER JOIN domicilio ON empleado.domicilioE=domicilio.idDomicilio WHERE users.activo=1";
            }else{
                sql = "SELECT idEmpleado, nombreE, apellidosE, users.user, permisos, activo, domicilio.calle, numero, numeroInt, colonia FROM empleado INNER JOIN users ON empleado.user=users.idUser INNER JOIN domicilio ON empleado.domicilioE=domicilio.idDomicilio";
            }
            Statement stat = conectar().createStatement();
            obtener=(ResultSet) stat.executeQuery(sql);
            System.out.println("chido");
        } catch(SQLException e){
            System.out.println("Error en la conexion "+e);
        }
        return obtener;
    }
}
