package org.almost.palindrome;

public class AlmostPalindrome {

	public AlmostPalindrome() {}
	
	private char[] reverse(char[] arr) {
		
		int n = arr.length;
		char[] reverse = new char[n];
		
		for (int i=0; i<n; i++) {
			reverse[i] = arr[n-1-i];
		}
		
		return reverse;
		
	}
	
	private char[] stringToArr(String oracion) {
		return oracion.toLowerCase().replace(" ", "").toCharArray();
	}
	
	public boolean isAlmostPalindrome(String oracion) {
		
		boolean response;
		
		char[] oracionArr = stringToArr(oracion);
		char[] oracionArrReverse = reverse(oracionArr);
		
		int counter = 0;
		
		for (int i=0; i<oracionArr.length; i++) {
			if(oracionArr[i] != oracionArrReverse[i]) {
				counter++;
			}
		}
		
		response = (counter == 2)? true: false;
		
		return response;
	}
	
}
