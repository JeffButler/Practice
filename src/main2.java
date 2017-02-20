
public class main2 {
	public class threadExample implements Runnable{
		public int count = 0;
		
		@Override
		public void run() {
			System.out.println("Thread has just started");
			try {
				while (count < 5){
					Thread.sleep(400);
					System.out.println(count);
					count++;
				}
			}
			catch(InterruptedException exp){
				System.out.println("Caught exception");
			}
			System.out.println("Thread finished running");
		}
		
	}
	
	public class threadExample2 extends Thread {
		int count = 10;
		String s = "kldf";
				
				
		public void run(){
			System.out.println("Thread Starting");
			try {
				while (count < 20){
					Thread.sleep(400);
					System.out.println(count);
					count++;
				}
			}
			catch(InterruptedException ex){
				System.out.println("Runnable Thread interrupted");
			}
			System.out.println("Thread finished");
		}
	}
	
	public static void main(String[] args){
		main2 m = new main2();
		threadExample example = m.new threadExample();
		Thread thread = new Thread(example);
		thread.start();
		
		while(example.count != 5){
			try {
				Thread.sleep(250);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		threadExample2 example2 = m.new threadExample2();
		example2.start();
		
		while (example2.count != 20){
			/*
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		
	}
	
	
}
