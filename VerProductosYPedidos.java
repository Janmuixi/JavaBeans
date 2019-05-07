package AccesoJavaBeans;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class VerProductosYPedidos {
	public static void main(String[] args) {
		DataBase dataBase= new DataBase();
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
	    dataBase.closeDatabase();
	}
	
}
