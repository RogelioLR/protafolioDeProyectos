package org.almost.palindrome.test;

import static org.junit.jupiter.api.Assertions.*;

import org.almost.palindrome.AlmostPalindrome;
import org.junit.jupiter.api.Test;

class AlmostPalindromeTestUnits {

	AlmostPalindrome casiPalindromo = new AlmostPalindrome();
	
	@Test
	void casiPalindromoTest() {
		assertEquals( false, casiPalindromo.isAlmostPalindrome("Oso"), "Verifca Oso"   );
		assertEquals( true, casiPalindromo.isAlmostPalindrome("Ver"), "Verifica Ver"   );
		assertEquals( false, casiPalindromo.isAlmostPalindrome("Hola"), "Verifica Hola"   );
		assertEquals( true, casiPalindromo.isAlmostPalindrome("Ocho"), "Verifica Ocho"   );
		assertEquals( false, casiPalindromo.isAlmostPalindrome("Veronica"), "Verifica Veronica"   );
		assertEquals( true, casiPalindromo.isAlmostPalindrome("Anita lavó la tina"), "Verifica Anita"   );
	}
	
}


/**	
* 
* Ejercicio Casi Palíndromo
* 
* Verificar si una palabra es casi palíndromo,
* con el cambio de una sola letra.
* 
* La función debe aceptar un texto y retornar
* con true si la palabra es casi palíndromo,
* de lo contrario retornar false.
* 
* Ej.
*  Oso -> false ( por que ya es un palíndromo)
*  Ver -> true (si reemplazo la v por r -> vev)
*  Hola -> false (no es casi un palíndromio: holh, hooa)
*  Ocho -> true ( occo)
*  Veronica -> false ( veronicv, veroniea, veronrca, verooica)
*  Anita lavó la tina - > true (  Anita L[a]v[a] la tina )
* 
*/