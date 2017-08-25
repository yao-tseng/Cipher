import java.util.*;
import java.io.*;

public class ROT13 {

	public static void main( String[] args ) {

		//create string variables, initiate to empty;
		//(String)input: user input string;
		//(String)plaintxt: user input string in uppercase without spaces;
		String input = "";
		String plaintxt = "";

		//check user inputs;
		//if input is empty, execute the program with default values;
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "now or never";
			plaintxt = "NOWORNEVER";
		}

		//if user input is not empty, convert input into uppercase string without spaces;
		else {
			for ( int i=0; i<args.length; i++ ) {
				input += args[i] + " ";
				plaintxt += args[i].toUpperCase();
			}
		}
		System.out.println( "Input     : " + input );

		//create variables;
		//(Array)plain: order of letters in plaintext;
		//(Array)cipher: order of letters in ciphertext;
		char[] plain = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		char[] cipher = { 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M' };

		//print data;
		System.out.print( "Plaintext : " + plaintxt + '\n' + "Ciphertext: " );

		//create variable; (Array)ciphertext: an array to store the ciphertext;
		char[] ciphertxt = encrypt( plaintxt, cipher );
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print( ciphertxt[i] );
		System.out.println();

		System.out.println( '\n' + "--convert rules--" );
		encryptRules( plain, cipher );
	}

	//encrypt;
	//return (Array)codeArr to (Array)ciphertext;
	public static char[] encrypt( String plaintxt, char[] cipher ) {
		//create variable; (Array)codeArr: an array to store the ciphertext;
		//the range of the ASCII code of each characters in the plaintext - 65 are in the interval 
		// [0,25], letters in corresponding position in (Array)cipher is the cipher code;
		char[] codeArr = new char[plaintxt.length()];		
		for ( int i=0; i<plaintxt.length(); i++ ) {
			codeArr[i] = (char)cipher[(int)plaintxt.charAt(i) - 65];
		}		
		return codeArr;
	}

	//print convert rules;
	public static void encryptRules( char[] plain, char[] cipher ) {
		for ( int p=0; p<26; p++ ) System.out.print( plain[p] );
		System.out.println();
		for ( int c=0; c<26; c++ ) System.out.print( cipher[c] );
		System.out.println('\n');
	}
}
