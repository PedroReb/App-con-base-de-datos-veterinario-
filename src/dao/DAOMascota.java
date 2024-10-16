/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexion.DBConnection;
import entidades.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author Alumno
 */
public class DAOMascota {
    
        public boolean insertarMascota(String numero, String nombre, String tipodeanimal, String raza, String fechadenacimiento, String dnicliente) throws ParseException {
        
        Connection conexion = new DBConnection().getConexion();

        try {
            String sql = "INSERT INTO Mascota (Numero, NombreMascota, TipoDeAnimal, Raza, FechaDeNacimiento, DniCliente) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement plataforma = conexion.prepareStatement(sql);
            plataforma.setString(1, numero);
	    plataforma.setString(2, nombre);
	    plataforma.setString(3, tipodeanimal);
            plataforma.setString(4, raza);
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date parsedDate = dateFormat.parse(fechadenacimiento);
            Date sqlDate = new Date(parsedDate.getTime());
            plataforma.setDate(5, sqlDate); 
            plataforma.setString(6, dnicliente);
	    int filasAfectadas = plataforma.executeUpdate();

            // Si se insertó correctamente, se devuelve true; de lo contrario, false
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        
    	public void add(Mascota mascota) {
		//pedir la conexión
		Connection conexion = new DBConnection().getConexion();

		try {

			String sql = "INSERT INTO mascota VALUES(?,?,?,?,?,?)";
			//Uso una plataforma "Preparada"
			PreparedStatement plataforma = conexion.prepareStatement(sql);
			//rellenar las interrogaciones
			plataforma.setString(1, mascota.getNumero());
			plataforma.setString(2, mascota.getNombre());
			plataforma.setString(3, mascota.getTipodeanimal());
                        plataforma.setString(4, mascota.getRaza());
                        plataforma.setString(5, mascota.getFechadenacimiento());
                        plataforma.setString(6, mascota.getDnicliente());
			plataforma.executeUpdate();

			//cerrar la conexión
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error insertando Persona");
			e.printStackTrace();
		}

	}
        	public void update(Mascota mascota) {
		//pedir la conexión
		Connection conexion = new DBConnection().getConexion();

		try {
			String sql = "UPDATE persona SET numero = ?, NombreMascota = ?, TipoDeAnimal = ?, Raza =?, FechaDeNacimiento = ?, DniCliente = ? WHERE numero = ?";
			//Uso una plataforma "Preparada"
			PreparedStatement plataforma = conexion.prepareStatement(sql);

			plataforma.setString(1, mascota.getNumero());
			plataforma.setString(2, mascota.getNombre());
			plataforma.setString(3, mascota.getTipodeanimal());
                        plataforma.setString(4, mascota.getRaza());
                        plataforma.setString(5, mascota.getFechadenacimiento());
                        plataforma.setString(6, mascota.getDnicliente());
			plataforma.executeUpdate();

			//cerrar la conexión
			conexion.close();

		} catch (SQLException e) {
			System.out.println("Error actualizando Mascota");
			e.printStackTrace();
		}
	}
    public ArrayList<Mascota> get(){
		//Preparo un arraylist para el resultado
		ArrayList<Mascota> lista = new ArrayList<Mascota>();
		//pedir la conexión
		Connection conexion = new DBConnection().getConexion();

		try {
			//Lanzar un SELECT
			String sql = "SELECT * FROM mascota";
                        
			//Uso una plataforma "Preparada"
			PreparedStatement plataforma = conexion.prepareStatement(sql);
			ResultSet resultado = plataforma.executeQuery();

			while(resultado.next()) { //cuando se acaben las tuplas, next() retorna false
				//tratamiento de cada tupla
				lista.add(new Mascota(resultado.getString("Numero"), resultado.getString("nombremascota"), resultado.getString("tipodeanimal"),resultado.getString("raza"),resultado.getString("fechadenacimiento"),resultado.getString("dnicliente")));
				//	lista.add(new Persona(resultado.getString(1), resultado.getString(2), resultado.getLong(3)));

			}
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error obteniendo mascotas");
			e.printStackTrace();
		}
		return lista;
	}
}
