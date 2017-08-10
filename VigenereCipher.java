import java.util.*;
import java.io.*;

class VigenereCipher {

	public static void main( String[] args ) {
		String input = "";
		String str = "";
		String key = "";
		
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "love never fails";
			str = "LOVENEVERFAILS";
			key = "KEY";
		}
		else if ( args.length == 1 ){
			System.out.println( "no key input, default key = \"key\"" );
			input = args[0];
			str = input.toUpperCase();
			key = "KEY";
		}
		else {
			for (int i=0; i<args.length-1; i++) {
				input += args[i] + " ";
				str += args[i].toUpperCase();
				key = args[args.length-1].toUpperCase();
			}
		}
		int keyLength = key.length();
		System.out.println( "Input     : " + input + '\n' + "String    : " + str + '\n' + "Key       : " + key + "   (length: " + keyLength + ")" );

		encrypt( str, key );
	}

	static void encrypt( String str, String key ) {
		int shift = 0;
		int code = 0;
		char[] codeArr = new char[str.length()];

		for ( int i=0; i<str.length(); i++ ) {
			shift = i % key.length();
			code = ( (int)str.charAt(i) + (int)key.charAt(shift) ) % 26 + (int)'A';
		
			System.out.println( str.charAt(i) + "-->" + (char)code + " (shift: " + (((int)key.charAt(shift) + 65 + 1) % 26) + ")" );
			codeArr[i] = (char)code;
		}

		System.out.print( "Ciphertext: " );
		for ( int i=0; i<str.length(); i++ ) System.out.print( codeArr[i] );
		System.out.println();
	}
}
