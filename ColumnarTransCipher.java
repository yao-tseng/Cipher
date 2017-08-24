import java.util.*;
import java.io.*;

class ColumnarTransCipher {

	public static void main( String[] args ) {
		
		//create initial variables;
		//(String)input: user input string;
		//(String)str: user input string in uppercase without spaces;
		//(String)key: user input key;
		String input = "";
		String str = "";
		String key = "";

		//check user inputs;
		//if input is empty, execute the program with default values;
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "life was like a box of chocolates";
			str = "LIFEWASLIKEABOXOFCHOCOLATES";
			key = "CIPHER";
		}

		//if input only contains one word, take the word as plaintext and execute the program
		//with default kay;
		else if ( args.length == 1 ) {
			System.out.println( "no key input, default key = \"key\"" );
			input = args[0];
			str = input.toUpperCase();
			key = "CIPHER";
		}

		//if input has more than two words, take all words except the last one as plaintext
		//and the last word as the key;
		//convert plaintext to uppercase;
		//plaintext should contain no spaces;
		else {
			for ( int i=0; i<args.length-1; i++ ) {
				input += args[i] + " ";
				str += args[i].toUpperCase();
				key = args[args.length-1].toUpperCase();
			}
		}

		//print input data
		int keyLen = key.length();
		int strLen = str.length();
		System.out.println( "Input     : " + input + '\n' + "Plaintext : " + str + '\n' + "   (length: " + strLen + ")" +'\n' + "Key       : " + key + '\n' + "   (length: " + keyLen + ")" );
		
		encrypt( str, key, keyLen, strLen );
		System.out.println();
	}

	static void encrypt ( String str, String key, int keyLen, int strLen ) {
		
		//create variables
		//(Array)keyArr: key letters;
		//(Array)sortedKeyArray: key letters sorted in ascending order;
		//(Array)strArr: string letters;
		char[] keyArr = new char[keyLen];
		char[] sortedKeyArr = new char[keyLen];
		char[] strArr = new char[strLen];
		
		//copy key string and plaintext string letter by letter into arrays;
		for ( int i=0; i<keyLen; i++ ) keyArr[i] = key.charAt(i);
		for ( int i=0; i<strLen; i++ ) strArr[i] = str.charAt(i);
		System.arraycopy( keyArr, 0, sortedKeyArr, 0, keyLen );
		Arrays.sort(sortedKeyArr);
		
		//create variable; (Array)order: order of the letters in key, 0~(length of key - 1);
		int[] order = new int[keyLen];
		//set all elements in the array to (length of key + 1);
		for ( int i=0; i<keyLen; i++ ) order[i] = keyLen+1;
		//for every element in the sorted key array, find the corresponding position in the
		//original kay array and update the order array;
		//if statement checks the letters and deals with duplicate letters; if element in
		//order array equals (length of key + 1), position not taken yet;
		for ( int i=0; i<keyLen; i++ ) {
			for ( int j=0; j<keyLen; j++) {
				if ( sortedKeyArr[i] == keyArr[j] && order[j] == keyLen+1 ) {
						order[j] = i;
						break;
				}
			}
		}

		//create variables;
		//(Array)codeArr: an array to store the ciphertext;
		//(Integer)columnCnt: column count, also, order count;
		//(Integer)codeIndex: index for code array;
		//(Integer)re: remainder;
		char[] codeArr = new char[strLen];
		int columnCnt = 0;
		int codeIndex = 0;
		int index = 0;
		int re = 0;

		//column count and remainder initiated to 0;
		while( columnCnt < keyLen ) {
			//identify column;
			for ( int i=0; i<keyLen; i++ )
				if ( order[i] == columnCnt ) re = i;
			//column identified, add the whole column to code array;
			for ( index=0; index<strLen; index++ ) {
				if ( index % keyLen == re ) {
					codeArr[codeIndex] = strArr[index];
					codeIndex = codeIndex + 1;
				}
			}
			columnCnt = columnCnt + 1;
		}

		//print data
		System.out.print( "Ciphertext: " );
		for ( int j=0; j<codeArr.length; j++ ) System.out.print( codeArr[j] );
		System.out.println();

		//convert rules
		System.out.println( '\n' + "--convert rules--" );
		//print key
		for ( int j=0; j<keyLen; j++ ) System.out.print( "  " + keyArr[j] );
		System.out.println();

		//print order
		if ( order[0]<9 ) System.out.print( " 0" + (order[0]+1) );
			else System.out.print( " " + (order[0]+1) );
		for ( int j=1; j<keyLen; j++ ) {
			if ( order[j]<9 ) System.out.print( " 0" + (order[j]+1) );
			else System.out.print( " " + (order[j]+1) );
		}
		System.out.println();

		//print plaintext, print new line every "key length" letters
		int c = 1;
		for ( int i=0; i<strLen; i++ ) {
			if ( c != keyLen ) {
				System.out.print( "  " + strArr[i] );
				c += 1;
			}
			else {
				System.out.println( "  " + strArr[i] );
				c = 1;
			}
		}
	}
}
