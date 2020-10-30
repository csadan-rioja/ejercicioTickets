package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import controlador.ControladorTickets;
import modelo.Ticket;

public class Principal {

	private static ControladorTickets ct = new ControladorTickets();

	
	private static void respuestaServidor(Socket cliente, String mensaje) throws IOException {
		PrintStream ps = new PrintStream(cliente.getOutputStream());
		ps.println("HTTP/1.1 200 OK");
		ps.println();
		ps.println(mensaje);
		ps.close();
	}
	
	
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(80);
			while (true) {
				Socket cliente = ss.accept();
				System.out.println("Conectado: "+cliente.getInetAddress().getHostAddress());

				BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
								
				String linea = br.readLine();
				String primeraLinea = linea;
				while (linea!=null && !linea.trim().equals("")) {
//					System.out.println(linea);
					linea = br.readLine();
				}
//				
				String[] lineaSeparada = primeraLinea.split(" ");
				String operacionyparametros = lineaSeparada[1];
				String[] operacionyparametrosSeparada = operacionyparametros.split("\\?");
				
				// GET /necesitoayuda?nombre=Carlos HTTP/1.1
				
				System.out.println("Peticion: "+primeraLinea);
				System.out.println("Servicio: "+operacionyparametrosSeparada[0]);
				if(operacionyparametrosSeparada[0].equals("/necesitoayuda")) {
					String nombre = operacionyparametrosSeparada[1];
					String valorNombre = nombre.split("=")[1];
					
					Ticket t = ct.necesitoAyuda(valorNombre);
					
					respuestaServidor(cliente, t.toString());
				
				// eliminarPeticion?id=...
				}else if(operacionyparametrosSeparada[0].equals("/eliminarPeticion")) {
					String id = operacionyparametrosSeparada[1];
					String valorId = id.split("=")[1];
					boolean b = ct.eliminarPeticion(valorId);
					respuestaServidor(cliente, String.valueOf(b));
				}
				// //3. resolverPeticion?id=...
				else if(operacionyparametrosSeparada[0].equals("/resolverPeticion")) {
					String id = operacionyparametrosSeparada[1];
					String valorId = id.split("=")[1];
					boolean b = ct.resolverPeticion(valorId);
					respuestaServidor(cliente, String.valueOf(b));
				}
				//4. siguienteTicket
				else if(operacionyparametrosSeparada[0].equals("/siguienteTicket")) {
					Ticket t = ct.siguienteTicket();
					respuestaServidor(cliente, t.toString());
				}
				//5. listaTicketsPendientes
				else if(operacionyparametrosSeparada[0].equals("/listaTicketsPendientes")) {
					List<Ticket> listaTickets = ct.listaTickets();
					StringBuffer sb = new StringBuffer();
					for (Ticket ticket : listaTickets) {
						sb.append(ticket.toString()+"\n");
					}
					respuestaServidor(cliente, sb.toString());
				}
				
				else {
					respuestaServidor(cliente, "La petición solicitada no corresponde con ningún servicio.");
				}
				
				cliente.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
