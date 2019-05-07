package AccesoJavaBeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

public class Venta implements Serializable, PropertyChangeListener {
	
	private int numeroVenta;
	private Producto producto;
	private Date fechaVenta;
	private int cantidad;
	private String observaciones;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		DataBase dataBase = new DataBase();
    	int idVenta = dataBase.getLastIdVenta();
    	Venta venta = new Venta(idVenta + 1, producto, new Date(), 1, "Pendiente de pedido\r\n" + "por falta de stock");
    	dataBase.insertVenta(venta);
    	System.out.printf("stock anterior: %d%n",evt.getOldValue());
    	System.out.printf("stock actual: %d%n",evt.getNewValue());
    	System.out.printf(venta.getObservaciones());
    	dataBase.closeDatabase();
	}
	
	public Venta(int numeroVenta, Producto producto, Date fechaVenta, int cantidad, String observaciones) {
		super();
		this.numeroVenta = numeroVenta;
		this.producto = producto;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.observaciones = observaciones;
		producto.setStockactual(producto.getStockactual() - cantidad);
	}
	
	public int getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Venta() {}
	
}
