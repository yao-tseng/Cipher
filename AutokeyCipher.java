import java.util.*;
import java.io.*;

class AutokeyCipher { 

	public static void main( String[] args ) {
		String input = "";
		String plaintxt = "";
		String key = "SECRET";
		
		if ( args.length == 0 ) {
			System.out.println( "empty imput, execute default..." );
			input = "hold my own";
			plaintxt = "HOLDMYOWN";
		}
		else if ( args.length == 1 ) {
			System.out.println( "no key input, default key = \"secret\"" );
			input = args[0];
			plaintxt = input.toUpperCase();
			key = "SECRET";
		}
		else {
			for ( int i=0; i<args.length-1; i++ ) {
				input += args[i] + " ";
				plaintxt += args[i].toUpperCase();
				key = args[args.length-1].toUpperCase();
			}
		}
		System.out.print( "Input     : " + input + '\n' + "Key       : " + key );

		String autoKey = keyGenerate( plaintxt, key );
		System.out.println( '\n' + "Auto Key  : " + autoKey );

		char[] codeArr = encrypt( plaintxt, autoKey );
		System.out.print( "Plaintext : " + plaintxt + '\n' + "Ciphertext: " );
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print( codeArr[i] );
		System.out.println();

		encryptRules( plaintxt, autoKey, codeArr );
	}

	static String keyGenerate( String plaintxt, String key ) {
		int keyLength = plaintxt.length();
		String autoKey = (key + plaintxt);
		autoKey = autoKey.substring(0, keyLength);
		
		return autoKey;
	}

	static char[] encrypt( String plaintxt, String autoKey ) {
		int code = 0;
		char[] codeArr = new char[plaintxt.length()];

		for ( int i=0; i<plaintxt.length(); i++ ) {
			code = ( (int)plaintxt.charAt(i) + (int)autoKey.charAt(i) ) % 26 + 65;		
			codeArr[i] = (char)code;
		}
		
		return codeArr;
	}

	static void encryptRules( String plaintxt, String autoKey, char[] codeArr ) {
		System.out.println( '\n' + "--convert rules--" );
		for ( int i=0; i<plaintxt.length(); i++ ) {
			int shift = (int)autoKey.charAt(i) - 65;
			System.out.print( plaintxt.charAt(i) + "-->" + codeArr[i] + " (shift: " );
			if ( shift<10 ) System.out.print( "0" );
			System.out.println( shift + ")" );
		}
	}
}
