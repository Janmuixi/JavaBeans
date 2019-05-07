package AccesoJavaBeans;

import java.math.BigDecimal;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class DataBase {
	private ODB odb;
	
	public void closeDatabase() {
		odb.close();
	}
	
	public void insertVenta(Venta venta) {
		odb.store(venta);
	}
	
	public void insertProducto(Producto producto) {
		odb.store(producto);
	}
	
	public void insertPedido(Pedido pedido) {
		odb.store(pedido);
	}
	
	public DataBase() {
		this.odb = ODBFactory.open("Producto_Ped.BD3");
	}
	
	public DataBase(ODB odb) {
		super();
		this.odb = odb;
	}

	public ODB getOdb() {
		return odb;
	}

	public void setOdb(ODB odb) {
		this.odb = odb;
	}
	
	public int getLastIdPedido() {	    
	    Values val = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numeroPedido", "ped_max"));
	    ObjectValues objVal = val.nextValues();
	    BigDecimal maxima = (BigDecimal) objVal.getByAlias("ped_max");
	    
	    return maxima.intValue();
	}
	public int getLastIdVenta() {	    
	    Values val = odb.getValues(new ValuesCriteriaQuery(Venta.class).max("numeroVenta", "venta_max"));
	    ObjectValues objVal = val.nextValues();
	    BigDecimal maxima = (BigDecimal) objVal.getByAlias("venta_max");
	    
	    return maxima.intValue();
	}
}
