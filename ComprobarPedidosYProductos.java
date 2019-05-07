package AccesoJavaBeans;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class ComprobarPedidosYProductos {

	public static void main(String[] args) {
		DataBase dataBase= new DataBase();
		VerProductos(dataBase);
		
		// Cerramos y abrimos al acabar el metodo la base de datos porque en el mismo metodo se llama a
		// un propertyChange que necesita abrirla de nuevo, y como no pueden haber dos abiertas a la vez
		// hacemos esto.
		dataBase.closeDatabase();
		ModificarProducto();
		dataBase = new DataBase();
		
		VerProductos(dataBase);
	    dataBase.closeDatabase();
	}

	private static void ModificarProducto() {
		
		Producto producto = new Producto(1,"MiProductoEstrella",10,3,16);
        Pedido pedido = new Pedido();
        pedido.setProducto(producto);
        Venta venta = new Venta();
        venta.setProducto(producto);
        producto.addPropertyChangeListener (pedido);
        producto.addPropertyChangeListener(venta);
        producto.setStockactual(2);
        System.out.println("**************Pedido Modificado**************");
	}

	private static void VerProductos(DataBase dataBase) {
		ODB odb = dataBase.getOdb();
		System.out.println("Productos: ");
		Objects<Producto> productos = odb.getObjects(Producto.class);
	    for(Producto producto : productos) {
	        System.out.println(producto.getDescripcion());
	        
	    }
	    System.out.println("Pedidos: ");
	    Objects<Pedido> pedidos = odb.getObjects(Pedido.class);
	    for(Pedido pedido : pedidos) {
	        System.out.println(pedido.getNumeroPedido());
	        
	    }
	    System.out.println("Ventas: ");
	    Objects<Venta> ventas = odb.getObjects(Venta.class);
	    for(Venta venta : ventas) {
	        System.out.println(venta.getNumeroVenta());
	        
	    }
	}

}
