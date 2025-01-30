package es.cie.repositories;

import java.util.List;
import es.cie.ordenadores.Ordenador;

public interface OrdenadorRepository {

	List<Ordenador> buscarTodos();
	void insertar(Ordenador ordenador);
	void borrar(Ordenador ordenador);
	List<Ordenador> buscarTodosOrdenados(String orden);
	
}
