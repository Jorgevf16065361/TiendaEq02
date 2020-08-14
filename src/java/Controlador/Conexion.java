/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.sql.*;
/**
 *
 * @author jaime
 */
public class Conexion {

    public static Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/sistemaventas";
            String usuario="root";
            String clave="";
            return DriverManager.getConnection(url,usuario,clave);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
