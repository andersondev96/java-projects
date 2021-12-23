package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// Nw
		p.setValues(position.getRows() - 1, position.getColum() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
			p.setValues(p.getRows() - 1, p.getColum() - 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// ne
		p.setValues(position.getRows() - 1, position.getColum() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
			p.setValues(p.getRows() - 1, p.getColum() + 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// se
		p.setValues(position.getRows() + 1, position.getColum() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
			p.setValues(p.getRows() + 1, p.getColum() + 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		// sw
		p.setValues(position.getRows() + 1, position.getColum() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
			p.setValues(p.getRows() + 1, p.getColum() - 1);

		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRows()][p.getColum()] = true;
		}

		return mat;
	}

}
