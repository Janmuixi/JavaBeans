package AccesoJavaBeans;

import java.util.Date;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class AllComponents {
	public static void main(String[] args) {
		System.out.println("Dame el id de un producto: ");
		Scanner scanner = new Scanner(System.in);
		int inputId = scanner.nextInt();
		
		DataBase dataBase = new DataBase();
		ODB odb = dataBase.getOdb();
		Objects<Producto> productos = odb.getObjects(Producto.class);
		
	    for(Producto tempProducto : productos) {
	        if (tempProducto.getIdproducto() == inputId) {
	        	System.out.println("Producto encontrado: " + tempProducto.getDescripcion() + " con stock: " + tempProducto.getStockactual());
	        	Venta venta = new Venta(dataBase.getLastIdVenta(), tempProducto, new Date(), 1, "");
		    	System.out.println(tempProducto.getStockactual());
	        }
	    }
	    
	    scanner.close();
	}
}
