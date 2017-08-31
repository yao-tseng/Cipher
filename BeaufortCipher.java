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
		int keyIndex = 0;
		int code = 0;
		char[] codeArr = new char[plaintxt.length()];

		//the ciphertext is the letter corresponding to the integer value(0~25) of the offset from plaintext to key;
		for ( int i=0; i<plaintxt.length(); i++ ) {
			keyIndex = i % key.length();
			code = ( (int)key.charAt(keyIndex) - (int)plaintxt.charAt(i) + 26 ) % 26 + (int)'A';
			codeArr[i] = (char)code;
		}

		//print out ciphertext
		System.out.print( "Ciphertext: " );
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print( codeArr[i] );
		System.out.println();

		//print out convert rules
		System.out.println( '\n' + "--convert rules--" );
		System.out.println( "plain_text --> cipher_text" + '\n' + "       (cipher_text : index_of_letter = key - plain_text)" );
		for ( int i=0; i<plaintxt.length(); i++ ) {
			String cipherIndex;
			keyIndex = i % key.length();
			int math = ((int)key.charAt(keyIndex) - (int)plaintxt.charAt(i) + 26) % 26;
			if ( math<10 ) cipherIndex = "0" + math;
			else cipherIndex = "" + math;
			System.out.println( plaintxt.charAt(i) + "-->" + codeArr[i] + "  (" +  codeArr[i] + ":" + cipherIndex + " = " + key.charAt(keyIndex) + "-" + plaintxt.charAt(i) + ")" );
		}
	}
}
