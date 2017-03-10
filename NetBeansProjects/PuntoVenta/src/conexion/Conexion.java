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
    
    private final String user = "133991";
    private final String password = "momantai";
    private final String url = "jdbc:mysql://mysql2.paris1.alwaysdata.com:3306/momantaiter_streetcode";
    
    private Connection con = null;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection)DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto correctamente");
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        return con;
    }
    
    public int validar(Login login){
        ResultSet obtener = null;
        String ID = login.getID();
        String contra = login.getPassword();
        int valido=0;
        
        try{
            System.out.println("salto");
            String sql = "SELECT * FROM users WHERE user = '" + ID + "' AND password = '"+ contra +"';";
            conectar();
            Statement statement= conectar().createStatement();
            
            ResultSet result= (ResultSet) statement.executeQuery(sql);
            
            if(result.next()){
                valido = result.getInt("permisos");
            }
            System.out.println("Se conecto correctamente");
        } catch(Exception e){
            System.out.println("Error en la conexion aqui " + e);
        }
        return valido;
    }
    
    public static void main(String[] args) {
        Conexion a = new Conexion();
        a.conectar();
    }
    
}
