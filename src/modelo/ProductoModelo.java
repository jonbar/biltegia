/**
 * 
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author enautirakasle 24 mar. 2017
 */
public class ProductoModelo extends Conector {

	public ArrayList<Producto> selectAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from productos");
			while (rs.next()) {
				productos.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("proveedor"),
						rs.getDouble("precio"), rs.getInt("existencias")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}

	Producto select(int id) {
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from productos where id='" + id + "'");
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
		try {
			Statement st = super.getConexion().createStatement();
			st.executeUpdate("UPDATE productos "
						 + "SET nombre='"  	 + producto.getNombre()  	+ "'"
						 + ",proveedor='"  + producto.getProveedor() 	+ "'"
						 + ",precio='" + producto.getPrecio() + "'"
						 + ",existencias='" + producto.getExistencias() + "'"
						 + " WHERE id=" + producto.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert(Producto producto) {
		
	}

}
