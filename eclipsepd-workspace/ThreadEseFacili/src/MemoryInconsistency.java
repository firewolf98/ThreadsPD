public class MemoryInconsistency {                
		int bar =0;
		public static void main(String args[]) {
			(new MemoryInconsistency()).unsafeCall();
		}
		
		void unsafeCall() {                 
			final MemoryInconsistency thisObj= this;
			Runnable r= new Runnable() {  
				public void run(){
					thisObj.bar=1;
				}
			};
			Thread t= new Thread(r);  
			t.start();
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {  
				e.printStackTrace();
			}
			System.out.println("bar="+ bar );
		}
	}
