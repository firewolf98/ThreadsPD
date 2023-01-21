
public class HelloThread implements Runnable{

	public static void main(String[] args) {
		(new Thread(new HelloThread())).start();

	}

	@Override
	public void run() {
		System.out.println("Hellofromathread!");
		
	}

}
