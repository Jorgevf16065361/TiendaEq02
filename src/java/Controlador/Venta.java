package Controlador;

import java.sql.*;
import java.util.*;
/**
 * 
 * @autor 
 * Archivo: Venta.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class Venta{

	private int venta_Codigo;
	private String venta_Fecha;
	private int usuario_Codigo;
	private double venta_TotalPagar;

	/** Crea un nueva instancia de la clase venta */
	public Venta(){

	}

    /**
     * Obtener el ultimo codigo que se genero de forma automatica
     * @return Retorna el codigo que se genero de la tabla Venta
     */
    private int ultimoCodigoInserto(Connection cn){
        int codigo=0;
        PreparedStatement pr=null;
        ResultSet rs=null;
        try{
            String sql="SELECT MAX(venta_Codigo) as Codigo FROM Venta";
            pr=cn.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                codigo=rs.getInt("Codigo");
                break;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                rs.close();
                pr.close();
            }catch(SQLException ex){

            }
        }
        return codigo;
    }

    /**
     * Metodo utilizado para registrar una venta dentro de la base de datos
     * @param v Informacion de la venta
     * @param dv Detalle de la venta
     * @return Retorma un valor valor boolean que indica si se registro o no en la base de datos la venta
     */
    public boolean registrarVenta(Venta v, Vector<Detalleventa> ldv){
        boolean registro=false;
        Connection cn=null;
        PreparedStatement pr=null;
        try{
            cn=Conexion.getConexion();
            String sql="INSERT INTO Venta(venta_Fecha,usuario_Codigo,venta_TotalPagar) ";
            sql+=" VALUES(?,?,?)";
            pr=cn.prepareStatement(sql);
            pr.setString(1, v.getVenta_fecha());
            pr.setInt(2, v.getUsuario_codigo());
            pr.setDouble(3, v.getVenta_totalpagar());
            //Se registro en la base de datos
            if(pr.executeUpdate()==1){
                int codigo=this.ultimoCodigoInserto(cn);
                registro=this.registrarDetalleVenta(codigo, ldv, cn);
            }else{
                registro=false;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;
        }finally{
            try{
                pr.close();
                cn.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }

    /**
     * Metodo utilizado para registrar el detalle de la venta
     * @param codigo Representa el codigo de la Venta
     * @param ldv Lista con los detalles de la Venta
     * @param cn Conexion con la base de datos
     */
    private boolean registrarDetalleVenta(int codigo, Vector<Detalleventa> ldv, Connection cn){
        boolean registro=false;
        PreparedStatement pr=null;
        try{
            for(Detalleventa dv : ldv){
                String sql="INSERT INTO DetalleVenta VALUES(?,?,?,?,?)";
                pr=cn.prepareStatement(sql);
                pr.setInt(1, codigo);
                pr.setInt(2, dv.getDetventa_item());
                pr.setInt(3, dv.getProducto_codigo());
                pr.setInt(4, dv.getDetventa_cantidad());
                pr.setDouble(5, dv.getDetventa_subtotal());
                if(pr.executeUpdate()==1){
                    registro=true;
                }else{
                    registro=false;
                    break;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            registro=false;
        }finally{
            try{
                pr.close();
            }catch(SQLException ex){

            }
        }
        return registro;
    }

	/** Metodos GET de la clase venta */
	public int getVenta_codigo(){
		 return this.venta_Codigo;
	}
	public String getVenta_fecha(){
		 return this.venta_Fecha;
	}
	public int getUsuario_codigo(){
		 return this.usuario_Codigo;
	}
	public double getVenta_totalpagar(){
		 return this.venta_TotalPagar;
	}

	/** Metodos SET de la clase venta */

	public void setVenta_codigo(int venta_Codigo){
		 this.venta_Codigo=venta_Codigo;
	}
	public void setVenta_fecha(String venta_Fecha){
		 this.venta_Fecha=venta_Fecha;
	}
	public void setUsuario_codigo(int usuario_Codigo){
		 this.usuario_Codigo=usuario_Codigo;
	}
	public void setVenta_totalpagar(double venta_TotalPagar){
		 this.venta_TotalPagar=venta_TotalPagar;
	}

}

