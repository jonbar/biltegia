/**
 * 
 */
package modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author enautirakasle
 * 24 mar. 2017
 */
public class ClienteModelo extends Conector{
	
	public ArrayList<Cliente> selectAll(){
		//TODO bezero guztiak itzuliko ditu
		return null;
	}
	
	public Cliente select(int id){
		//TODO id hori duen cliente itzultzen du
		return null;
	}
	
	public void update(Cliente cliente){
		//TODO clienteren id-a erabilita update egiten du
	}
	
	public void insert(Cliente cliente){
		Statement st;
		try {
			st = super.getConexion().createStatement();
			System.out.println("INSERT INTO socios (id,nombre,direccion,codPostal,telefono) " 
					 + "VALUES ('" + cliente.getId() + "','"
					 + cliente.getNombre() + "','"
		 			 + cliente.getDireccion() + "','" 
		 			 + cliente.getCodPostal() + "','" 
		 			 + cliente.getTelefono() + "')");
			st.execute("INSERT INTO socios (id,nombre,direccion,codPostal,telefono) " 
					 + "VALUES ('" 	+ cliente.getId() + "','"
					 				+ cliente.getNombre() + "','"
					 				+ cliente.getNombre() + "','"
					 				+ cliente.getCodPostal() + "','" 
					 				+ cliente.getTelefono() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
