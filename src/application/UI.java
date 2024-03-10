package application;

import chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		for(int i=0; i<pieces.length; i++) {
			System.out.println((8 - i) + " " + String.join(" ", printRow(pieces[i])));
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static String[] printRow(ChessPiece[] row) {
		String[] result = new String[row.length];
		for(int j=0; j<row.length; j++) {
			result[j] = printPiece(row[j]);
		}
		return result;
	}
	
	private static String printPiece(ChessPiece piece) {
		return piece == null ? "-" : piece.toString();
	}
}

