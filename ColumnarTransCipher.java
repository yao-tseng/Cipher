import java.util.*;
import java.io.*;

class ColumnarTransCipher {

	public static void main( String[] args ) {
		String input = "";
		String str = "";
		String key = "";
		
		if ( args.length == 0 ) {
			System.out.println( "empty input, execute default..." );
			input = "love never fails";
			str = "LOVENEVERFAILS";
			key = "KEY";
		}
		else if ( args.length == 1 ) {
			System.out.println( "no key input, default key = \"key\"" );
			input = args[0];
			str = input.toUpperCase();
			key = "KEY";
		}
		else {
			for ( int i=0; i<args.length-1; i++ ) {
				input += args[i] + " ";
				str += args[i].toUpperCase();
				key = args[args.length-1].toUpperCase();
			}
		}
		int keyLength = key.length();
		System.out.println( "Input     : " + input + '\n' + "String    : " + str + '\n' + "Key       : " + key + "   (length: " + keyLength + ")" + '\n' );

		encryptRules( str, key );
	}

	static void encryptRules ( String str, String key ) {
		int strLen = str.length();
		int keyLen = key.length();
		char[] keyArr = new char[keyLen];
		char[] sortedKeyArr = new char[keyLen];
		char[] strArr = new char[strLen];
		
		for ( int i=0; i<keyLen; i++ ) keyArr[i] = key.charAt(i);
		for ( int i=0; i<strLen; i++ ) strArr[i] = str.charAt(i);
		System.arraycopy( keyArr, 0, sortedKeyArr, 0, keyLen );
		Arrays.sort(sortedKeyArr);
		
		int[] order = new int[keyLen];
		for ( int i=0; i<keyLen; i++ ) order[i] = keyLen+1;
		for ( int i=0; i<keyLen; i++ ) {
			for ( int j=0; j<keyLen; j++) {
				if ( sortedKeyArr[i] == keyArr[j] && order[j] == keyLen+1 ) {
						order[j] = i;
						break;
				}
			}
		}

		int numOfRows = strLen / keyLen;
		if ( strLen % keyLen != 0 ) numOfRows = numOfRows + 1;
		char[][] block = new char[keyLen][numOfRows];
		
		char[] codeArr = new char[strLen];
		int columnCnt = 0;
		int codeIndex = 0;
		int index = 0;
		int re = 0;
		while( columnCnt < keyLen ) {
			for ( int i=0; i<keyLen; i++ )
				if ( order[i] == columnCnt ) re = i;
			for ( index=0; index<strLen; index++ ) {
				if ( index % keyLen == re ) {
					codeArr[codeIndex] = strArr[index];
					codeIndex = codeIndex + 1;
				}
			}
			columnCnt = columnCnt + 1;
		}

		System.out.println( '\n' + "-------------------------" + 
				'\n' + "strLen:" + strLen + 
				'\n' + "keyLen:" + keyLen + '\n' );
		for ( int j=0; j<keyLen; j++ ) System.out.print( sortedKeyArr[j] );
		System.out.println();
		for ( int j=0; j<keyLen; j++ ) System.out.print( keyArr[j] );
		System.out.println();
		System.out.print( (order[0]+1) );
		for ( int j=1; j<keyLen; j++ ) System.out.print( "," + (order[j]+1) );
		System.out.println();
		for ( int j=0; j<codeArr.length; j++ ) System.out.print( codeArr[j] );
		System.out.println();
	}
}
