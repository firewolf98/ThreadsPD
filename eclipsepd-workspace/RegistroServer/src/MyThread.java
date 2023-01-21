import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Logger;

public class MyThread extends java.lang.Thread {

	Socket socket;
	HashMap<String, RegistroRecord> hash;
	Logger logger;

	public MyThread(Socket socket, HashMap<String, RegistroRecord> hash) {
		this.socket = socket;
		this.hash = hash;
		logger = Logger.getLogger("global");
	}

	public void run() {
		try {
			logger.info("Accetto una connessione... attendo comandi...");
		
			ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
			RegistroRecord record = (RegistroRecord) inStream.readObject();
		
			if (record.getIndirizzo() != null) {
				logger.info("Inserosco: " + record.getNome() + ", " + record.getIndirizzo());
				synchronized(hash) {
					hash.put(record.getNome(), record);
				}
			} else {
				logger.info("Cerco: " + record.getNome());
				RegistroRecord res;
				synchronized(hash) {
					res = hash.get(record.getNome());
				}
				ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
				outStream.writeObject(res);
				outStream.flush();
			}
		
			socket.close();

		} catch (EOFException e) {
			// TODO Auto-generated catch block
			logger.severe("Problemi di connessione: " + e.getMessage());
			e.printStackTrace();
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			logger.severe("Lanciata Trowable: " + t.getMessage());
			t.printStackTrace();
		}

	}

}
