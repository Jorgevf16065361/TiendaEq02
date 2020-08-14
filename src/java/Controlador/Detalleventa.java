package Controlador;

/**
 * 
 * @autor 
 * Archivo: Detalleventa.java
 * Creado: 6/5/2009 02:35:26 PM
 */
public class Detalleventa{

	private int venta_Codigo;
	private int detVenta_Item;
	private int producto_Codigo;
	private int detVenta_Cantidad;
	private double detVenta_SubTotal;

	/** Crea un nueva instancia de la clase detalleventa */
	public Detalleventa(){

	}

	/** Metodos GET de la clase detalleventa */
	public int getVenta_codigo(){
		 return this.venta_Codigo;
	}
	public int getDetventa_item(){
		 return this.detVenta_Item;
	}
	public int getProducto_codigo(){
		 return this.producto_Codigo;
	}
	public int getDetventa_cantidad(){
		 return this.detVenta_Cantidad;
	}
	public double getDetventa_subtotal(){
		 return this.detVenta_SubTotal;
	}

	/** Metodos SET de la clase detalleventa */

	public void setVenta_codigo(int venta_Codigo){
		 this.venta_Codigo=venta_Codigo;
	}
	public void setDetventa_item(int detVenta_Item){
		 this.detVenta_Item=detVenta_Item;
	}
	public void setProducto_codigo(int producto_Codigo){
		 this.producto_Codigo=producto_Codigo;
	}
	public void setDetventa_cantidad(int detVenta_Cantidad){
		 this.detVenta_Cantidad=detVenta_Cantidad;
	}
	public void setDetventa_subtotal(double detVenta_SubTotal){
		 this.detVenta_SubTotal=detVenta_SubTotal;
	}

}

