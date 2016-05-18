package creation;

import java.util.Arrays;

public class 삼육구 {
	
	private static int[] MagicNumber = {3, 6, 9};
	private int rangeStart = 700; 
	private int rangeEnd = 1000;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		삼육구 test = new 삼육구();
		test.run();
	}
	
	
	/**
	 * 삼육구 시작 
	 */
	public void run() {
		
		for (int startIndex = rangeStart; startIndex <= rangeEnd; startIndex++) {
			
			int modNumber = 10;
			int divdeNumber = 1;
			int number = startIndex;
			int magicNumberCount = 0;
			
			while (number >= divdeNumber) {
				
				int quotient = (number % modNumber) / divdeNumber;
				
				if (Arrays.binarySearch(MagicNumber, quotient) >= 0) {
					magicNumberCount++;
					System.out.print("짝");
				}
				modNumber *= 10;
				divdeNumber *= 10;
			}
			
			if (magicNumberCount == 0) {
				System.out.println(startIndex);
			} else {
				System.out.println();
			}
		}
		
		
		
	}
	
	
	
	
	
}
