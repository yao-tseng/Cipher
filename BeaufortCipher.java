import java.util.*;
import java.io.*;

class BeaufortCipher {

	public static void main( String[] args ) {
		String input = "";
		String str = "";
		String key = "";

		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "only the strong survive";
			str = "ONLYTHESTRONGSURVIVE";
			key = "IVERSON";
		}
		else if ( args.length == 1 ) {
			System.out.println( "no key input, default key = \"IVERSON\"" );
			input = args[0];
			str = input.toUpperCase();
			key = "IVERSON";
		}
		else {
			for ( int i=0; i<args.length-1; i++ ) {
				input += args[i] + " ";
				str += args[i].toUpperCase();
				key = args[args.length-1].toUpperCase();
			}
		}

		System.out.println( "Input     : " + input + '\n' + "String    : " + str + '\n' + "Key       : " + key + "   (length: " + key.length() + ")" + '\n' );

		encrypt( str, key );
	}

	static void encrypt( String str, String key ) {
		int offset = 0;
		int code = 0;
		char[] codeArr = new char[str.length()];

		for ( int i=0; i<str.length(); i++ ) {
			offset = i % key.length();
			code = ( (int)key.charAt(offset) - (int)str.charAt(i) + 26 ) % 26 + (int)'A';
		
			System.out.println( str.charAt(i) + "-->" + (char)code + " (offset: " + (((int)key.charAt(offset) + 65) % 26) + ")" );
			codeArr[i] = (char)code;
		}

		System.out.print( '\n' + "Plaintext : " + str + '\n' + "Ciphertext: " );
		for ( int i=0; i<str.length(); i++ ) System.out.print( codeArr[i] );
		System.out.println();
	}

}
