import java.util.*;
import java.io.*;

class CaesarCipher {

	public static void main( String[] args ) {
		//create variables;
		//(String)input: user input string;
		//(String)plaintxt: user input string in uppercase without spaces; 
		//(Integer)shift: shift amount between plaintext and ciphertext. set default to 1;
		String input = "";
		String plaintxt = "";
		int shift = 1;
		
		//check user input;
		//if user input is empty, set plaintext to "hakunamatata" and execute program with default
		// shift;
		if ( args.length == 0 ) {
			input = "hakuna matata (by default)";
			plaintxt = "hakunamatata";
		}
		//if user input is a single number, set shift amount to the number and plaintext to
		// "hakunamatata";
		//if user input is a single word, set plaintext to the word and execute with default shift;
		else if ( args.length == 1 ) {
			try { 
				shift= Integer.parseInt( args[0] );
				input = "hakuna matata (by default)";
				plaintxt = "hakunamatata";
			} catch ( NumberFormatException nfe ) {
				input = args[0];
				plaintxt = args[0];
			}
		}
		//if user input contains two or more arguments, take all arguments except the last one
		// without spaces as plaintext and the last argument as shift amount;
		//if the last argument is not a number, concatenate the last argument to plaintext and
		// execute with default shift;
		else {
			try { 
				for ( int i=0; i<args.length-1; i++ ) {
					input += args[i] + " ";
					plaintxt += args[i];
				}
				shift = Integer.parseInt( args[args.length-1] );
			} catch ( NumberFormatException nfe ) {
				input += args[args.length-1];
				plaintxt += args[args.length-1];
			}
		}
		
		//print input data;
		if ( args.length < 2 ) System.out.println( "input incorrect, execute default.." );
		System.out.println( "Input     : " + input + '\n' + "Shift     : " + shift );

		shiftRules( shift );
		encrypt( plaintxt, shift );
	}

	//(Function)shiftRules: shifting rules;
	//print out the alphabet string from A to Z and the corresponding encrypted string;
	static void shiftRules( int shift ) {
		//(String)plain: alphabets in A~Z order;
		//(String)cipher: corresponding encrypted string;
		String plain = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String cipher = plain.substring(shift % 26) + plain.substring(0, shift % 26);
		System.out.println("\n" + "Plain : " + plain);
		System.out.println( "Cipher: " + cipher );
	}

	//(Function)encrypt: encrypt input string;
	static void encrypt( String plaintxt, int shift ) {
		//(Integer)code: integer value of letter in ciphertext;
		//set plaintext to all uppercase;
		int code = 0;
		plaintxt = plaintxt.toUpperCase();
		System.out.println( "\n" + "Plaintext : " + plaintxt );
		System.out.print( "Ciphertext: " );

		//convert the uppercase letters in plaintext, do not convert all other characters;
		for ( int i=0; i<plaintxt.length(); i++ ) {
			if ( plaintxt.charAt(i) > 64 && plaintxt.charAt(i) < 91 ) {
				code = ( (int)plaintxt.charAt(i) + 13 + shift ) % 26 + (int)'A';
				System.out.print( (char)(code) );
			}
			else System.out.print( plaintxt.charAt(i) );
		}
		System.out.println();
	}
}
