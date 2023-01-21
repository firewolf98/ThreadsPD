import java.util.Random;

public class ArraySomma implements Runnable {

	public static void main(String[] args)  {
		Random r=new Random();
		for (int i=0;i<r.nextInt(8)+1;i++) {
			new Thread(new ArraySomma()).start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
	
	@Override
	public void run() {
		int[] array=new int[1000000];
		for(int i=0;i<1000000;i++)
			array[i]=i;
		int sum=0;
		for (int i=0;i<1000000;i++)
			sum=sum+array[i];
		System.out.println(Thread.currentThread().getName()+" "+"Secondi:"+" "+System.currentTimeMillis()+" "+"Totale:"+" "+sum);
	}

}
