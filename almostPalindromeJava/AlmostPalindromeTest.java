package org.almost.palindrome;

public class AlmostPalindromeTest {

	public static void main(String[] args) {
		
		AlmostPalindrome casiPalindromo = new AlmostPalindrome();
		String oracion = "Anita lavo la tina";
		
		boolean is = casiPalindromo.isAlmostPalindrome(oracion);
		
		System.out.println(oracion);
		System.out.println(is);

	}

}
