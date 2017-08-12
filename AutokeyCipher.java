import java.util.*;
import java.io.*;

class AutokeyCipher { 

	public static void main( String[] args ) {
		String input = "";
		String str = "";
		String key = "SECRET";
		
		if ( args.length == 0 ) {
			System.out.println( "empty imput, execute default..." );
			input = "hold my own";
			str = "HOLDMYOWN";
		}
		else if ( args.length == 1 ) {
			System.out.println( "no key input, default key = \"secret\"" );
			input = args[0];
			str = input.toUpperCase();
			key = "SECRET";
		}
		else {
			for ( int i=0; i<args.length-1; i++ ) {
				input += args[i] + " ";
				str += args[i].toUpperCase();
				key = args[args.length-1].toUpperCase();
			}
		}
		System.out.print( "Input    : " + input + '\n' + "String   : " + str + '\n' + "Key      : " + key );

		String autoKey = encryptRules( str, key );
		System.out.println( '\n' + "Auto Key : " + autoKey + '\n' );

		encrypt( str, autoKey );
	
	}

	static String encryptRules( String str, String key ) {

		int keyLength = str.length();
		String autoKey = (key + str);
		autoKey = autoKey.substring(0, keyLength);
		
		return autoKey;
	}

	static void encrypt( String str, String autoKey ) {
		int code = 0;
		char[] codeArr = new char[str.length()];
		for ( int i=0; i<str.length(); i++) {
			code = ( (int)str.charAt(i) + (int)autoKey.charAt(i) ) % 26 + (int)'A';
			
			System.out.println( str.charAt(i) + "-->" + (char)code + "(shift: " + (((int)autoKey.charAt(i) + 65) % 26) + ")" );
			codeArr[i] = (char)code;
		}
		
		System.out.print( '\n' + "Plaintext : " + str + '\n' + "Ciphertext: " );
		for ( int i=0; i<str.length(); i++ ) System.out.print( codeArr[i] );
		System.out.println();
	}



}
