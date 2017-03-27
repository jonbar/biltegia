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
public class ClienteModelo extends Conector {

	ClienteModelo(String biltegia) {
		super(biltegia);
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Cliente> selectAll(){
		// bezero guztiak itzuliko ditu

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try{
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from clientes");
			while(rs.next()){
				clientes.add(new Cliente(rs.getString("id"),rs.getString("nombre"),rs.getString("direccion"),rs.getString("codPostal"),rs.getString("telefono")));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return clientes;
	}
	

	public Cliente select(int id) {
		// TODO id hori duen cliente itzultzen du
		return null;
	}

	public void update(Cliente cliente) {
		// TODO clienteren id-a erabilita update egiten du
	}

	public void insert(Cliente cliente) {
		// TODO clienteren insert egiten du
	}

}
