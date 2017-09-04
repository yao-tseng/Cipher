import java.util.*;
import java.io.*;

class CaesarCipher {

	public static void main( String[] args ) {
		String str = "";
		int shift = 1;
		
		if ( args.length < 2 ) {
			System.out.println( "input incorrect, execute default.." );
			str = "hakunamatata";
		}
		else {
			try { 
				for ( int i=0; i<args.length-1; i++ ) str += args[i];
				shift = Integer.parseInt( args[args.length-1] );
			} catch ( NumberFormatException nfe ) {
				str += args[args.length-1];
			}
		}
		System.out.println( "String: " + str + '\n' + "Shift : " + shift );

		shiftRules( shift );
		encrypt( str, shift );
	}

	static void shiftRules( int shift ) {
		String plain = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String cipher = plain.substring(shift % 26) + plain.substring(0, shift % 26);
		System.out.println("\n" + "Plain : " + plain);
		System.out.println( "Cipher: " + cipher );
	}

	static void encrypt( String str, int shift ) {
		int code = 0;
		char letter;
		str = str.toUpperCase();
		System.out.println( "\n" + "Plaintext : " + str );
		System.out.print( "Ciphertext: " );

		for ( int i=0; i<str.length(); i++ ) {
			if ( str.charAt(i) > 64 && str.charAt(i) < 91 ) {
				code = ( (int)str.charAt(i) + 13 + shift ) % 26 + (int)'A';
				System.out.print( (char)(code) );
			}
			else System.out.print( str.charAt(i) );
		}
		System.out.println();
	}
}
