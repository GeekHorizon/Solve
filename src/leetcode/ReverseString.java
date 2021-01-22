package leetcode;

/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * Input: ["h","e","l","l","o"] 
 * Output: ["o","l","l","e","h"]
 */
public class ReverseString {
	
	public static void main(String[] args) {
		
		ReverseString r = new ReverseString();
		
		char[] s = new char[] {'h','e','l','l','o'};
		r.reverseString(s);
		System.out.println(s);
		
	}
	
    public void reverseString(char[] s) {
        reverse(0, s);
    }
    
    private void reverse(int index, char[] s) {
    	if (index == s.length / 2) {
    		return ;
    	}
    	
    	char item = s[index];
    	s[index] = s[s.length - index - 1];
    	s[s.length - index - 1] = item;
    	
    	reverse(index + 1, s);
    }
}
