package AccesoJavaBeans;

import org.neodatis.odb.Objects;

public class LlenarProductos {
	public static void main(String[] args) {
		DataBase dataBase= new DataBase();
    	
    	Producto p1 = new Producto(1, "Duruss Cobalt", 10, 3, 220);
		Producto p2 = new Producto(2, "Varlion Avant Carbon", 5, 2, 176);
		Producto p3 = new Producto(3, "Star Vie Pyramid R50", 20, 5, 193);
		Producto p4 = new Producto(4, "Dunlop Titan", 8, 3, 85);
		Producto p5 = new Producto(5, "Vision King", 7, 1, 159);
		Producto p6 = new Producto(6, "Slazenger Reflex Pro", 5, 2, 80);
		
		dataBase.insertProducto(p1);
		dataBase.insertProducto(p2);
		dataBase.insertProducto(p3);
		dataBase.insertProducto(p4);
		dataBase.insertProducto(p5);
		dataBase.insertProducto(p6);
		
		dataBase.closeDatabase();
	}
}
