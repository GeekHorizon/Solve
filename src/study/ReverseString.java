package study;

public class ReverseString {

	public static void main(String[] args) {
		printReverse("Print a string in reverse order.".toCharArray());
		printReverse(".redro esrever ni gnirts a tnirP".toCharArray());
	}

	private static void printReverse(char[] str) {
		helper(0, str);
		System.out.println(new String(str));
	}

	private static void helper(int index, char[] str) {
		if (index == str.length / 2) {
			return;
		}

		char item = str[index];
		str[index] = str[str.length - 1 - index];
		str[str.length - 1 - index] = item;

		helper(index + 1, str);
	}

}
