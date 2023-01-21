import java.io.EOFException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class server {
	static Logger logger=Logger.getLogger("global");
	
	public static void main(String[] args) {
		while(true) {
		try {
		
			ServerSocket serverSocket=new ServerSocket(9000);
			logger.info("Socket istanziato,accetto connessioni...");
			Socket socket=serverSocket.accept();
			logger.info("Accettata una connessione...attendo comandi.");
			ObjectOutputStream outStream=new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inStream=new ObjectInputStream(socket.getInputStream());
			Thread t=new threadClass(socket,outStream,inStream);
			t.start();
		}
		catch (EOFException e) {
			logger.severe("Problemi con la connessione:"+ e.getMessage());
			e.printStackTrace();
		}
		catch (Throwable t) {
			logger.severe("Lanciata Throwable:"+t.getMessage());
			t.printStackTrace();
		}
		}
	}
}