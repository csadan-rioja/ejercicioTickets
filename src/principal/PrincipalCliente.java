package principal;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class PrincipalCliente {
	
	public static void main(String[] args) {
		try {
			
			for (int i = 0; i < 1000; i++) {
				Socket s = new Socket("192.168.6.100", 80);
				PrintStream ps = new PrintStream(s.getOutputStream());
				ps.println("GET /necesitoayuda?nombre=Carlos HTTP/1.1");
				ps.println();
				ps.println();
				ps.close();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
