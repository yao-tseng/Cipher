import java.util.*;
import java.io.*;

class BeaufortCipher {

	public static void main( String[] args ) {

		//create string variables, initial to empty;
		//(String)input: user input string;
		//(String)plaintxt: user input string in uppercase without spaces;
		//(String)key: user input key;
		String input = "";
		String plaintxt = "";
		String key = "";

		//check user inputs;
		//if input is empty, execute the program with default values;
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "only the strong survive";
			plaintxt = "ONLYTHESTRONGSURVIVE";
			key = "IVERSON";
		}

		//if input only contains one word, take the word as plaintext and execute the program 
		// with default key;
		else if ( args.length == 1 ) {
			System.out.println( "no key input, default key = \"IVERSON\"" );
			input = args[0];
			plaintxt = input.toUpperCase();
			key = "IVERSON";
		}

		//if input has more than two words, take all words except the last one as plaintext
		// and the last word as the key;
		//convert plaintext and key to uppercase;
		//plaintext should contain no spaces;
		else {
			for ( int i=0; i<args.length-1; i++ ) {
				input += args[i] + " ";
				plaintxt += args[i].toUpperCase();
				key = args[args.length-1].toUpperCase();
			}
		}

		//print input data;
		System.out.println( "Input     : " + input + '\n' + "Plaintext : " + plaintxt + '\n' + "Key       : " + key + '\n' + "   (length: " + key.length() + ")" );

		encrypt( plaintxt, key );
	}

	static void encrypt( String plaintxt, String key ) {
		//create variables;
		//(Integer)offset: shift amount of each letters in plaintext;
		//(Integer)code: letter in ciphertext in ASCII;
		//(Array)codeArr: an array to store the ciphertext;
		int offset = 0;
		int code = 0;
		char[] codeArr = new char[plaintxt.length()];

		//convert letter at offset location with integer value of key at remainder of i/(lenght of key) location
		for ( int i=0; i<plaintxt.length(); i++ ) {
			offset = i % key.length();
			code = ( (int)key.charAt(offset) - (int)plaintxt.charAt(i) + 26 ) % 26 + (int)'A';
			codeArr[i] = (char)code;
		}

		//print out ciphertext
		System.out.print( "Ciphertext: " );
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print( codeArr[i] );
		System.out.println();

		//print out convert rules
		System.out.println( '\n' + "--convert rules--" );
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.println( plaintxt.charAt(i) + "-->" + codeArr[i] + " (offset: " + (((int)key.charAt(i%key.length()) + 65) % 26) + ")" );	
	}
}
