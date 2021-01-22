package study;

public class Factorial {
	
	
	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.factorial(10));
	}
	
	public int factorial(int n) {
		
		if (n == 1) {
			return 1;
		}
		
		
		return factorial(n - 1) * n;
	}
}
