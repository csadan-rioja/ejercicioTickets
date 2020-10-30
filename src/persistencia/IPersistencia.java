package persistencia;

import java.util.List;

import modelo.Ticket;

public interface IPersistencia {
	
	/**
	 * @param nombre Nombre de la persona que pide el ticket
	 * @return Objeto ticket generado para la petición
	 */
	public Ticket nuevoTicket(String nombre);
	
	/**
	 * @param idTicket Identificador del ticket a eliminar
	 * @return Verdadero en caso de ser eliminado y falso en caso contrario
	 */
	public Boolean eliminarTicket(String idTicket);
	
	/**
	 * @param idTicket Identificador del ticket para ser marcado como resuelto.
	 * @return Verdadero si se ha realizado la operación y falso en caso contrario. 
	 */
	public Boolean resolverTicket(String idTicket);
	
	/**
	 * @return Objeto ticket en proceso de ser resuelto
	 */
	public Ticket siguienteTicket();
	
	
	/**
	 * @return Lista de tickets para ser atendidos
	 */
	public List<Ticket> listaTicketsSiguientes();
}
