package controlador;

import java.util.List;
import modelo.Ticket;
import persistencia.IPersistencia;
import persistencia.PersistenciaJDBC;
import persistencia.PersistenciaMemoria;

public class ControladorTickets {
	
	IPersistencia persistencia = new PersistenciaMemoria();
	
	//1. necesitoAyuda?nombre=...
	public Ticket necesitoAyuda(String nombre) {
		return this.persistencia.nuevoTicket(nombre);
	}
	
	//2. eliminarPeticion?id=...
	public Boolean eliminarPeticion(String idTicket) {
		return this.persistencia.eliminarTicket(idTicket);
	}
	
	//3. resolverPeticion?id=...
	public Boolean resolverPeticion(String idTicket) {
		return this.persistencia.resolverTicket(idTicket);
	}
	
	//4. siguienteTicket
	public Ticket siguienteTicket() {
		return this.persistencia.siguienteTicket();
	}
	
	//5. listaTicketsPendientes
	public List<Ticket> listaTickets(){
		return this.persistencia.listaTicketsSiguientes();
	}
}





