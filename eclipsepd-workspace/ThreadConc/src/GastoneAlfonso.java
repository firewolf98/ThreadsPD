public class GastoneAlfonso {
  static class Amico {  
	  private final String name; 
	  
	  public Amico(String name) {
		  this.name =name;
	  }
	 
	  public String getName() {  
		  return this.name;
	  }
	  
	  public synchronized void bow(Amico bower) {  
		  System.out.format("%s:%s"+" has bowed to me!%n",this.name, bower.getName());  
		  bower.bowBack(this);
	  }
	  
	  public synchronized void bowBack(Amico bower) {  
		  System.out.format("%s:%s"+" has bowed back to me!%n",this.name,bower.getName());
	  }
  }
  
  public static void main(String[] args) {
	  final Amico alfonso=new Amico("Alfonso");  
	  final Amico gastone=new Amico("Gastone");
	  new Thread(new Runnable() { public void run() { alfonso.bow(gastone);}}).start();
	  new Thread(new Runnable(){ public void run() { gastone.bow(alfonso);}}).start();
  }
}
