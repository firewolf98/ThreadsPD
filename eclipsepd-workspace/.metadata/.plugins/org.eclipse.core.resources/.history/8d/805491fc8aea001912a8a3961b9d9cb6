import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;


public class threadClass extends Thread{
	final Socket socket;
	final ObjectOutputStream out;
	final ObjectInputStream in;
	static Logger logger=Logger.getLogger("global");
	
	public threadClass(Socket socket,ObjectOutputStream out,ObjectInputStream in) {
		this.socket=socket;
		this.out=out;
		this.in=in;
	}

	public void run() {
		String name;
			try {
				name=(String) in.readObject();
				out.writeObject("Hello "+name);
				this.socket.close();
			}
			catch(EOFException e) {
				logger.severe("Problemi con la connessione:"+e.getMessage());
				e.printStackTrace();
			}
			catch (Throwable t) {
				logger.severe("Lanciata Throwable:"+t.getMessage());
				t.printStackTrace();
			}
		
	}
}
