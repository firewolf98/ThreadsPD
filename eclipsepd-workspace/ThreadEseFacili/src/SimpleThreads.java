public class SimpleThreads {
	static void threadMessage(String msg) {
		String tn =Thread.currentThread().getName();
		System.out.format("%s:%s%n", tn,msg);
	}
	
	private static class MessageLoop implements Runnable {
		public void run() {  
			String impinf[] ={"Mareseatoats","Doeseatoats",  "Littlelambseativy",  "Akidwilleativytoo"};
			try {
				for(int i= 0; i < impinf.length; i++) {  
					Thread.sleep(4000);  
					threadMessage(impinf[i]);
				}
			}
			catch(InterruptedException e) {  
				threadMessage("I wasn’t done!");
			}
		}
	}
	
	public static void main(String args[]) throws InterruptedException {
		long patience = 16000;
		if(args.length > 0) {  
			try{
				patience = Long.parseLong(args[0]) *1000;
			}
			catch(NumberFormatException e) { 
				System.err.println("Argumentmustbean  integer.");
				System.exit(1);
			}
		}
		threadMessage("StartingMessageLoopthread");  
		long startTime= System.currentTimeMillis();  
		Thread t =new Thread(new MessageLoop());  
		t.start();	
		threadMessage("WaitingforMessageLooptofinish");
		while(t.isAlive()) {  
			threadMessage("Stillwaiting...");
			t.join(1000);
			if(((System.currentTimeMillis() -startTime) >  patience)&& t.isAlive()) {
				threadMessage("Tiredofwaiting!");  
				t.interrupt();
				t.join();
			}
		}
		threadMessage("Finally!");
	}
			
}