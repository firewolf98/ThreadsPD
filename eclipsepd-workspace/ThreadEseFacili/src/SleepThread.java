public class SleepThread{  
	public static void main(String args[]) throws InterruptedException {
		String importantInfo[] ={"Mareseatoats",  "Doeseatoats",  "Littlelambseativy",  "Akidwilleativytoo"};
		for(int i=0; i<importantInfo.length; i++) { 
			Thread.sleep(4000);  
			System.out.println(importantInfo[i]);
		}
	}
}