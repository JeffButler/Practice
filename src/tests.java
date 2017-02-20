import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class tests {
	public static int recursivefib(int n){
		if (n == 0)
			return 0;
		else if (n == 1){
			return 1;
		}
		else 
			return recursivefib(n-1) + recursivefib(n-2);
	}
	

	static int[] fib = new int[200];
	static int[] fib2 = new int[200];
	
	public int dpfib2(int n){
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (fib2[n] != 0) // return if the value is cached
			return fib2[n];
		fib2[n] = dpfib(n -1) + dpfib(n -2); // continue the recursion 
		return fib2[n];
	}
	
	public static int dpfib(int n){
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (fib[n] != 0) // return if the value is cached
			return fib[n];
		fib[n] = dpfib(n -1) + dpfib(n -2); // continue the recursion 
		return fib[n];
	}

	public static void main(String[] args){
		int n = 40;
		Object obj = null;
			try {
				obj.equals(new Object());
			} 
			catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("Null pointer exception bitch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("General Exception hoe");
			}
		System.out.println("Starting DP Fib With " + n);
		System.out.println("Done DP Fib " + dpfib(n));
		System.out.println("Starting Recusrive Fib With " + n);
		System.out.println("Done Recursive Fib " + recursivefib(n));
		
		
	}
}
