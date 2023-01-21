import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {

	static Logger logger = Logger.getLogger("global");
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		String host = args[0];
		String cmd = "";
		
		Scanner in = new Scanner(System.in);
		try {
			while(!cmd.equals("quit")) {
				
				System.out.println("Comandi:");
				System.out.println("Inserisci");
				System.out.println("Cerca");
				System.out.println("Quit\n");
				System.out.print("Comando>");
				
				cmd = in.nextLine();
				if(cmd.equals("inserisci")) {
					System.out.print("Inserisci Nome: ");
					String nome = in.nextLine();
					System.out.print("Inserisci Indirizzo: ");
					String indirizzo = in.nextLine();
					RegistroRecord r = new RegistroRecord(nome, indirizzo);
					Socket socket = new Socket(host, 7000);
					
					ObjectOutputStream sock_out = new ObjectOutputStream(socket.getOutputStream());
					sock_out.writeObject(r);
					sock_out.close();
					
				} else if(cmd.equals("cerca")) {
					System.out.print("Inserisci Nome: ");
					String nome = in.nextLine();
					
					RegistroRecord r = new RegistroRecord(nome, null);
					Socket socket = new Socket(host, 7000);
					
					ObjectOutputStream sock_out = new ObjectOutputStream(socket.getOutputStream());
					sock_out.writeObject(r);
					
					ObjectInputStream sock_in = new ObjectInputStream(socket.getInputStream());
					RegistroRecord result = (RegistroRecord) sock_in.readObject();
					
					if(result != null) {
						System.out.println("Indirizzo: " + result.getIndirizzo());
					} else {
						System.out.println("Record non presente");
					}
					
					socket.close();
				}
				
			}
		}catch(Throwable t) {
			
			logger.severe("Lanciata Throwable:" +t.getMessage());
			t.printStackTrace();
		}
		
		System.out.println("Bye Bye");
	}
}
