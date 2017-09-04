import java.util.*;
import java.io.*;

public class AtbashCipher {

	public static void main( String[] args ) {

		//create string variables, initial to empty;
		//(String)input: user input string;
		//(String)plaintxt: user input string in uppercase without spaces;
		String input = "";
		String plaintxt = "";
		
		//check user input;
		//if user input is empty, execute cipher program with default value;
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "to infinity and beyond";
			plaintxt = "TOINFINITYANDBEYOND";
		}
		//if input isn't empty, take the words except for spaces as plaintext;
		else {
			for ( int i=0; i<args.length; i++ ) {
				input += args[i] + " ";
				plaintxt += args[i].toUpperCase();
			}
		}

		//print input data;
		System.out.println( "Input     : " + input );
		System.out.print( "Plaintext : " + plaintxt + '\n' + "Ciphertext: " );

		//Atbash Cipher rule: maps each alphabet to its reverse;
		//(Array)plain: an array of alphabet order in plaintext;
		//(Array)cipher: an array of alphabet order in ciphertext;
		char[] plain = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		char[] cipher = new char[26]; 
		for (int i=0; i<26; i++) cipher[i] = plain[26-1-i];

		//(Array)ciphertext: an array to store ciphertext;
		//call function "encrypt" to encrypt;
		char[] ciphertext = encrypt( plaintxt, plain, cipher );
		//print out ciphertext;
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print( ciphertext[i] );
		System.out.println();

		//call function "convertRules";
		System.out.println( '\n' + "--convert rules--" );
		encryptRules( plain, cipher );
	}

	//(Function)encryptRules: encrypt rules;
	//convert each alphabet to its reverse, print out the arrays;
	public static void encryptRules( char[] plain, char[] cipher ) {
		for ( int p=0; p<26; p++ ) System.out.print( plain[p] );
		System.out.println();
		for ( int c=0; c<26; c++ ) System.out.print( cipher[c] );
		System.out.println();
	}

	//(Function)encrypt: encrypt input string;
	//return codeArr as ciphertext;
	public static char[] encrypt( String plaintxt, char[] plain, char[] cipher ) {
		//(Array)codeArr: an array to store ciphertext;
		char[] codeArr = new char[plaintxt.length()];
		//reverse input string alphabet by alphabet;
		for ( int i=0; i<plaintxt.length(); i++ ) codeArr[i] = (char)cipher[(int)plaintxt.charAt(i) - 65];
		return codeArr;
	}
}
