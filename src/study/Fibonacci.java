package study;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		Fibonacci fibonacci = new Fibonacci();
		
		System.out.println(fibonacci.fibonaccRecursive(30));
		System.out.println(fibonacci.finonacciRepeat(30));
		System.out.println(fibonacci.fibonacciDp(30));
	}
	
	
	public int fibonaccRecursive(int n) {
		
		if (n <= 1) {
			return n;
		}
		
		return fibonaccRecursive(n - 2) + fibonaccRecursive(n - 1);
	}
	
	
	private Map<Integer, Integer> dp = new HashMap<>();
	
	public int fibonacciDp(int n) {
		if (n <= 1) {
			return n;
		}
		
		if (dp.containsKey(n)) {
			return dp.get(n);
		}
		
		int num = fibonacciDp(n - 2) + fibonacciDp(n - 1);
		dp.put(n, num);
		return num;
	}
	
	public int finonacciRepeat(int n) {
		
		if (n <= 1) {
			return n;
		}
		
		
		int firstNumber = 0;
		int secondNumber = 1;
		int presentNumber = 1;
		
		for (int i = 3; i <= n; i++) {
			firstNumber = secondNumber;
			secondNumber = presentNumber;
			
			presentNumber = firstNumber + presentNumber;
		}
		
		return presentNumber;
	}
	
}
