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
    public int validar(Login login){
        ResultSet obtener = null;
        
        /*Se recuperan los datos de las variables de la clase Login*/
        String ID = login.getID();
        String contra = login.getPassword();
        int valido=0;
        
        try{//Se hace la consulta de el usuario y la contraseña en la base de datos
            System.out.println("salto");
            String sql = "SELECT * FROM users WHERE user = '" + ID + "' AND password = '"+ contra +"';";
            conectar();//Se conecta a la base de datos
            Statement statement= conectar().createStatement();
            
            /*Se utiliza ResultSet para acceder a los datos de las columnas y filas de la base de datos.
            Se crea un ubjeto llamado "result"*/
            ResultSet result= (ResultSet) statement.executeQuery(sql);
            
            if(result.next()){
                /*Se extrae el dato de la columna "permisos"*/
                valido = result.getInt("permisos");//el dato que se extrajo se iguala a la variable valido
            }
            System.out.println("Se conecto correctamente");
        } catch(Exception e){
            System.out.println("Error en la conexion aqui " + e);
        }
        return valido;//Se retorna la variable "valido" con el respectivo valor que se igualo
    }
    
    public static void main(String[] args) {
        Conexion a = new Conexion();
        a.conectar();
    }
    
}
