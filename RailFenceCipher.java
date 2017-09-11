import java.util.*;
import java.io.*;

public class RailFenceCipher {

	public static void main( String[] args ) {
		//create variables;
		//(String)input: user input;
		//(String)plaintxt: user input in uppercase without spaces;
		//(Integer)numOfRails: user set number of rails;
		String input = "";
		String plaintxt = "";
		int numOfRails = 3;
		
		//user input is empty, use default values;
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "to infinity and beyond";
			plaintxt = "TOINFINITYANDBEYOND";
		}

		//if user input is a single number, set to be the number of rail;
		//if user input is a single word, set to be the plaintext;
		else if ( args.length == 1 ) {
			try { 
				input = "to infinity and beyond";
				plaintxt = "TOINFINITYANDBEYOND";
				numOfRails = Integer.parseInt( args[0] );
			} catch ( NumberFormatException nfe ) {
				input = args[0];
				plaintxt = args[0];
			}
		}

		//if user inputs more than one agrument, take the last argument as the number of rail and all
		//others as plaintext;
		//if the last argument input is not a number, concatenate the last argument to plaintext;
		else {
			try {
				for ( int i=0; i<args.length-1; i++ ) {
					input += args[i] + " ";
					plaintxt += args[i];
				}
				numOfRails = Integer.parseInt( args[args.length-1] );
			} catch ( NumberFormatException nfe ) {
				input += args[args.length-1];
				plaintxt += args[args.length-1];
			}
		}
		//plaintext should be all in uppercase;
		plaintxt = plaintxt.toUpperCase();
		
		//print input data;
		System.out.println( "Input     : " + input + '\n' + "# of rails: " + numOfRails );

		//(Array)codeArr: an array which stores ciphertext;
		//call function "encrypt";
		char[] codeArr = encrypt( numOfRails, plaintxt );
		System.out.print( "Plaintext : " + plaintxt + '\n' + "Ciphertext: " );
		//print ciphertext;
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print(codeArr[i]);
		System.out.println();

		encryptRules( numOfRails, plaintxt );
	}

	//(Function)encrypt: encrypt plaintext;
	public static char[] encrypt( int numOfRails, String plaintxt ) {
		//(Integer)indexPt: index of letters in plaintext;
		//(Integer)railCnt: rail count;
		//(Array)arr: array for storing ciphertext;
		//(Integer)indexCt: index of letters in ciphertext;
		int indexPt = 0;
		int railCnt = 0;
		char[] arr = new char[plaintxt.length()];
		int indexCt = 0;

		while( railCnt<numOfRails ) {		
			for ( indexPt=0; indexPt<plaintxt.length(); indexPt++ ) {
				int math = indexPt % ( (numOfRails-1) * 2 );
				if ( math == railCnt || math == ( (numOfRails-1) * 2 - railCnt) ) {
					arr[indexCt] = plaintxt.charAt(indexPt);
					indexCt = indexCt + 1;
				}
			}
			railCnt = railCnt + 1;
		}

		return arr;
	}

	//(Function)encryptRules: encryption rules;
	public static void encryptRules( int numOfRails, String plaintxt ) {
		//(Integer)indexPt: index of letters in plaintext;
		//(Integer)railCnt: rail count;
		//(Array)arr: array for storing ciphertext;
		//(Integer)indexCt: index of letters in ciphertext;
		int indexPt = 0;
		int railCnt = 0;
		char[] arr = new char[plaintxt.length()];
		int indexCt = 0;

		System.out.println( '\n' + "--convert rule--" );
		while( railCnt<numOfRails ) {		
			for ( indexPt=0; indexPt<plaintxt.length(); indexPt++ ) {
				int math = indexPt % ( (numOfRails-1) * 2 );
				if ( math == railCnt || math == ( (numOfRails-1) * 2 - railCnt) )
					System.out.print( plaintxt.charAt(indexPt) );
				else System.out.print( "-" );
			}
			railCnt = railCnt + 1;
			System.out.println();
		}
	}
}
