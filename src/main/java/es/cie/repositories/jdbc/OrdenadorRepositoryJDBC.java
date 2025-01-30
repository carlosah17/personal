package es.cie.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.ordenadores.Ordenador;
import es.cie.repositories.OrdenadorRepository;

public class OrdenadorRepositoryJDBC implements OrdenadorRepository {

	static final String DB_URL="jdbc:mysql://localhost:3306/personal";
	static final String USER="root";
	static final String PASS="";
	@Override
	public List<Ordenador> buscarTodos() {
		
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		List<Ordenador> lista= new ArrayList<Ordenador>();
		//registra el driver para poderme conectar
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			//para preparar la sentencia sql a lanzar
			 sentencia= conexion.createStatement();
			// una vez que ejecuto la sentencia
			// el resultado se asigna a un resultset
			
			 rs=sentencia.executeQuery("select * from ordenadores");
			 while(rs.next()) {
				 
				 Ordenador o= new Ordenador(rs.getString("marca"),
						 rs.getInt("precio"));
				 lista.add(o);
			 }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	@Override
	public void insertar(Ordenador ordenador) {
	
		Connection conexion=null;	
		Statement sentencia=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia= conexion.createStatement();
			String insertarSql = "insert into ordenadores values('"+ordenador.getMarca()+"','"
			+ordenador.getPrecio()+"','"+"')";
			
			System.out.println(insertarSql);
			
			sentencia.executeUpdate(insertarSql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void borrar(Ordenador ordenador) {
		
		
		Connection conexion=null;	
		Statement sentencia=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia= conexion.createStatement();
			
			
			String borrarSql = "delete from ordenadores where dni='"+ordenador.getMarca()+"'";
			System.out.println(borrarSql);
			
			sentencia.executeUpdate(borrarSql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Ordenador> buscarTodosOrdenados(String orden) {
		
		
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		List<Ordenador> lista= new ArrayList<Ordenador>();
		//registra el driver para poderme conectar
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(DB_URL,USER,PASS);
			//para preparar la sentencia sql a lanzar
			 sentencia= conexion.createStatement();
			// una vez que ejecuto la sentencia
			// el resultado se asigna a un resultset
			
			 rs=sentencia.executeQuery("select * from ordenador order by "+ orden);
			 while(rs.next()) {
				 
				 Ordenador o= new Ordenador(rs.getString("marca"),
						 rs.getInt("precio"));
				 lista.add(o);
			 }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
		
	}

	
	
	
	
	
	
	
	
	
	
}
