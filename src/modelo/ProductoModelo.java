/**
 * 
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author enautirakasle
 * 24 mar. 2017
 */
public class ProductoModelo extends Conector{
	
	public ArrayList<Producto> selectAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>(); 
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios");
			while(rs.next()){
				productos.add(new Producto());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}
	
	Producto select(int id){
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios where id='" + id + "'");
			rs.next();
			Producto producto = new Producto();
			producto.setId(id);
			producto.setNombre(rs.getString("nombre"));
			producto.setProveedor(rs.getString("proveedor"));
			producto.setPrecio(rs.getDouble("precio"));
			producto.setExistencias(rs.getInt("existencias"));
			return producto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return null;
	}
	
	public void update(Producto producto) {
		
	}
	
	public void insert(Producto producto) {
			Statement st;
			try {
				st = super.getConexion().createStatement();
				System.out.println("INSERT INTO socios (id,nombre,direccion,codPostal,telefono) " 
						 + "VALUES ('" + producto.getId() + "','"
						 + producto.getNombre() + "','"
			 			 + producto.getProveedor() + "','" 
			 			 + producto.getPrecio() + "','" 
			 			 + producto.getExistencias() + "')");
				st.execute("INSERT INTO socios (id,nombre,direccion,codPostal,telefono) " 
						 + "VALUES ('" 	+ producto.getId() + "','"
						 				+ producto.getNombre() + "','"
						 				+ producto.getProveedor() + "','"
						 				+ producto.getPrecio() + "','" 
						 				+ producto.getExistencias() + "')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
