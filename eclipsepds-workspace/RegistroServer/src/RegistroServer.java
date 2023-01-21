import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Logger;

public class RegistroServer {
	static Logger logger = Logger.getLogger("global");

	public static void main(String[] args) {
		Socket socket = null;
		HashMap<String, RegistroRecord> hash = new HashMap<String, RegistroRecord>();
		try {
			ServerSocket serverSocket = new ServerSocket(7000);
			logger.info("Socket instanziato, accetto connessioni...");

			while (true) {
				socket = serverSocket.accept();
				MyThread t = new MyThread(socket, hash);
				t.start();

			}

		} catch (EOFException e) {
			// TODO Auto-generated catch block
			logger.severe("Problemi di connessione: " + e.getMessage());
			e.printStackTrace();
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			logger.severe("Lanciata Trowable: " + t.getMessage());
			t.printStackTrace();
		}
		
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
