package creation;

/**
 * Fizz Buzz는 1부터 100까지 리스트를 만들고 3으로 나눌 수 있는 수는 Fizz를 5로 나눌 수 있는 단어는 Buzz를 출력하게 만들게 요구합니다.
 * @author partyjoy2001
 *
 */
public class FizzBuzz {
	
	private int rangeStart = 7;
	private int rangeEnd = 10500;
	private static int MagicNumberFizz = 3;
	private static int MagicNumberBuzz = 5;
	
	public static void main(String[] args) {
		
		FizzBuzz test = new FizzBuzz();
		test.run();
		
	}
	
	
	/**
	 * 범위내에 모든수 수행
	 */
	public void run() {
		int fizzNumber = rangeStart; 
		
		if (rangeStart % MagicNumberFizz > 0) {
			fizzNumber = rangeStart + MagicNumberFizz - rangeStart % MagicNumberFizz;
		}
		
		int buzzNumber = rangeStart; 
		
		if (rangeStart % MagicNumberBuzz > 0) {
			buzzNumber = rangeStart + MagicNumberBuzz - rangeStart % MagicNumberBuzz;
		}
		
		for (int i = rangeStart; i <= rangeEnd; i++) {
			
			if (i == fizzNumber && i == buzzNumber) {
				System.out.println("FizzBuzz");
				fizzNumber += MagicNumberFizz;
				buzzNumber += MagicNumberBuzz;
			} else if (i == fizzNumber) {
				System.out.println("Fizz");
				fizzNumber += MagicNumberFizz;
			} else  if (i == buzzNumber) {
				System.out.println("Buzz");
				buzzNumber += MagicNumberBuzz;
			} else {
				System.out.println(i);
			}
			 
			
		}
			
		
		
	/*	for (int i = rangeStart; i <= rangeEnd; i++) {
			
			if (i % MagicNumberFizz == 0 && i % MagicNumberBuzz == 0) {
				System.out.println("FizzBuzz");
			} else if (i % MagicNumberFizz == 0) {
				System.out.println("Fizz");
			} else if (i % MagicNumberBuzz == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}*/
		
	}
	
}
