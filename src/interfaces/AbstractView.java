package interfaces;

import view.Escaner;
/**
 * 
 * Clase abstracta de la clase View a partir de la interfaz IGUI
 *
 */
public abstract class AbstractView implements IGUI {

	protected IDDBB db;
	protected Escaner sc;
}
