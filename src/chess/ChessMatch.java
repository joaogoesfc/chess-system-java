package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i < board.getRows(); i++) {
			for (int j =0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j);
			}
		}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private void validateSourcePosition(Position positio) {
		if (!board.thereIsAPiece(positio)) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void placeNewPiece(ChessPiece piece, char column, int row) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece(new Rook(board, Color.WHITE), 'a', 1);
        placeNewPiece(new Rook(board, Color.WHITE), 'h', 1);
        placeNewPiece(new Knight(board, Color.WHITE),'b', 1 );
        placeNewPiece(new Knight(board, Color.WHITE), 'g', 1);
        placeNewPiece(new Bishop(board, Color.WHITE), 'c', 1);
        placeNewPiece(new Bishop(board, Color.WHITE), 'f', 1);
        placeNewPiece(new King(board, Color.WHITE), 'e', 1);

        placeNewPiece(new Rook(board, Color.BLACK), 'a', 8);
        placeNewPiece(new Rook(board, Color.BLACK), 'h', 8);
        placeNewPiece(new Rook(board, Color.BLACK), 'b', 8);
        placeNewPiece(new Rook(board, Color.BLACK), 'g', 8);
        placeNewPiece(new Bishop(board, Color.BLACK), 'c', 8);
        placeNewPiece(new Bishop(board, Color.BLACK), 'f', 8);
        placeNewPiece(new King(board, Color.BLACK), 'e', 8);
		
	}
 }
