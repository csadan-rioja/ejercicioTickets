package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Ticket;

public class PersistenciaMemoria implements IPersistencia {
	private Integer i;
	private List<Ticket> listaTickets;
	
	public PersistenciaMemoria() {
		listaTickets = new ArrayList<Ticket>();
		i=0;
	}
	
	@Override
	public Ticket nuevoTicket(String nombre) {
		Ticket nuevoTicket = new Ticket(String.valueOf(i), nombre, false, new Date());
		i++;
		
		listaTickets.add(nuevoTicket);
		
		return nuevoTicket;
	}

	@Override
	public Boolean eliminarTicket(String idTicket) {
		Ticket ticketAEliminar = new Ticket();
		ticketAEliminar.setId(idTicket);
		return listaTickets.remove(ticketAEliminar);
	}

	@Override
	public Boolean resolverTicket(String idTicket) {
		Boolean isResuelto =false;
		
		for (Ticket ticket : listaTickets) {
			if(ticket.getId().equals(idTicket)) {
				ticket.setResuelto(true);
				isResuelto=true;
				break;
			}
		}
		
		return isResuelto;
	}

	@Override
	public Ticket siguienteTicket() {
		Ticket siguienteTicket= null;
		
		for (Ticket ticket : this.listaTickets) {
			if(!ticket.getResuelto()) {
				siguienteTicket = ticket;
				break;
			}
		}
		
		return siguienteTicket;
	}

	@Override
	public List<Ticket> listaTicketsSiguientes() {
		List<Ticket> listaDevuelta = new ArrayList<Ticket>();
		
		for (Ticket ticket : this.listaTickets) {
			if(!ticket.getResuelto()) {
				listaDevuelta.add(ticket);
			}
		}
		
		return listaDevuelta;
	}

}
