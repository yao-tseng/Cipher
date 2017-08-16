import java.util.*;
import java.io.*;

public class RailFenceCipher {

	public static void main( String[] args ) {
		String input = "";
		String plaintxt = "";
		int numOfRails = 3;
		
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "to infinity and beyond";
			plaintxt = "TOINFINITYANDBEYOND";
		}
		
		else if ( args.length == 1 ) {
			try {
				numOfRails = Integer.parseInt( args[0] );
				input = "to infinity and beyond";
				plaintxt = "TOINFINITYANDBEYOND";
			} catch ( NumberFormatException nfe ) {
				input = args[0];
				plaintxt = args[0];
			}
		}

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
		plaintxt = plaintxt.toUpperCase();
		
		System.out.println( "Input     : " + input + '\n' + "Plaintext : " + plaintxt + '\n' + "# of rails: " + numOfRails );
		System.out.println();

		encrypt( numOfRails, plaintxt );
	}

	public static void encrypt( int numOfRails, String plaintxt ) {
		int index = 0;
		int railCnt = 0;
		char[] arr = new char[plaintxt.length()];
		int a = 0;

		while( railCnt<numOfRails ) {		
			for ( index=0; index<plaintxt.length(); index++ ) {
				int math = index % ((numOfRails-1)*2);
				if ( math == railCnt || math == ((numOfRails-1) * 2 - railCnt) ) {
					arr[a] = plaintxt.charAt(index);
					a = a + 1;
				}
			}
			railCnt = railCnt + 1;
		}
		for ( int i=0; i<plaintxt.length(); i++ ) System.out.print( arr[i] );
		System.out.println();
	}
}
