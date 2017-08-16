import java.util.*;
import java.io.*;

public class AtbashCipher {

	public static void main( String[] args ) {
		String input = "";
		String plaintxt = "";
		
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "to infinity and beyond";
			plaintxt = "TOINFINITYANDBEYOND";
		}
		else {
			for ( int i=0; i<args.length; i++ ) {
				input += args[i] + " ";
				plaintxt += args[i].toUpperCase();
			}
		}
		System.out.println( "Input     : " + input );

		char[] plain = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		char[] cipher = new char[26]; 
		for (int i=0; i<26; i++) cipher[i] = plain[26-1-i];

		System.out.println( '\n' + "--convert rules--" );
		encryptRules( plain, cipher );

		System.out.print( "Plaintext : " + plaintxt + '\n' + "Ciphertext: " );

		char[] ciphertext = encrypt( plaintxt, plain, cipher );
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print( ciphertext[i] );
		System.out.println();
	}

	public static void encryptRules( char[] plain, char[] cipher ) {
		for ( int p=0; p<26; p++ ) System.out.print( plain[p] );
		System.out.println();
		for ( int c=0; c<26; c++ ) System.out.print( cipher[c] );
		System.out.println('\n');
	}

	public static char[] encrypt( String plaintxt, char[] plain, char[] cipher ) {
		int index = 0;
		char[] codeArr = new char[plaintxt.length()];		
		for ( int i=0; i<plaintxt.length(); i++ ) codeArr[i] = (char)cipher[(int)plaintxt.charAt(i) - 65];
		return codeArr;
	}
}
