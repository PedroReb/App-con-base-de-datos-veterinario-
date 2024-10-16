/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexion.DBConnection;
import entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Alumno
 */
public class DAOCliente {
    public ArrayList<Cliente> get(){
		//Preparo un arraylist para el resultado
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		//pedir la conexión
		Connection conexion = new DBConnection().getConexion();

		try {
			//Lanzar un SELECT
			String sql = "SELECT * FROM cliente";
			//Uso una plataforma "Preparada"
			PreparedStatement plataforma = conexion.prepareStatement(sql);
			ResultSet resultado = plataforma.executeQuery();

			while(resultado.next()) { //cuando se acaben las tuplas, next() retorna false
				//tratamiento de cada tupla
				lista.add(new Cliente(resultado.getString("dni"), resultado.getString("nombre"), resultado.getString("telefono"),resultado.getString("direccion"),resultado.getString("FechaDeNacimiento")));
				//	lista.add(new Persona(resultado.getString(1), resultado.getString(2), resultado.getLong(3)));

			}
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error obteniendo personas");
			e.printStackTrace();
		}
		return lista;
	}
        public Cliente get(String dni) {
		//Preparo una variable para guardar el objeto que busco
	Cliente p = null;
		//pedir la conexión
	Connection conexion = new DBConnection().getConexion();

            try {
			//Lanzar un SELECT
			String sql = "SELECT * FROM personas WHERE dni=?";
			//Uso una plataforma "Preparada"
			PreparedStatement plataforma = conexion.prepareStatement(sql);
			plataforma.setString(1, dni); //rellenamos el dni en la ?
			ResultSet resultado = plataforma.executeQuery();

			if(resultado.next()) { //si ha venido una tupla, la trabajamos
				//tratamiento de la tupla
				p = new Cliente(resultado.getString("dni"), resultado.getString("nombre"), resultado.getString("telefono"),resultado.getString("direccion"),resultado.getString("FechaDeNacimiento"));
			}
                        
			conexion.close();
            } catch (SQLException e) {
			System.out.println("Error obteniendo personas");
			e.printStackTrace();
            }
		return p;
	}

}
