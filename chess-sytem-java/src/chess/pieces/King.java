package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;

	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRows() - 1, position.getColum());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// below
		p.setValues(position.getRows() + 1, position.getColum());

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// left
		p.setValues(position.getRows(), position.getColum() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// right
		p.setValues(position.getRows(), position.getColum() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// nw
		p.setValues(position.getRows() - 1, position.getColum() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// ne
		p.setValues(position.getRows() - 1, position.getColum() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// sw
		p.setValues(position.getRows() + 1, position.getColum() - 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// se
		p.setValues(position.getRows() - 1, position.getColum() + 1);

		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// specialmove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// specialmove castling kingsside rook

			Position posT1 = new Position(position.getRows(), position.getColum() + 3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getRows(), position.getColum() + 1);
				Position p2 = new Position(position.getRows(), position.getColum() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRows()][position.getColum() + 2] = true;
				}
			}

			// specialmove castling queenside rook

			Position posT2 = new Position(position.getRows(), position.getColum() - 4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getRows(), position.getColum() - 1);
				Position p2 = new Position(position.getRows(), position.getColum() - 2);
				Position p3 = new Position(position.getRows(), position.getColum() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRows()][position.getColum() - 2] = true;
				}
			}
		}

		return mat;
	}
}