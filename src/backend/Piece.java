//Piece.java
package src.chess_game_backend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    //members
    //protected UUID
    protected boolean isBlack;
    protected PieceType pieceType;
    protected Location loc;
    protected boolean neverMoved = true;
    protected ChessBoard board; //reference to the board

    //constructor
    protected Piece() {
        this(PieceType.Pawn, true);
    }
    protected Piece(PieceType pieceType, boolean isBlack) {
        this.pieceType = pieceType;
        this.isBlack = isBlack;
    }
    protected Piece(PieceType pieceType, boolean isBlack, Location loc) {
        this.pieceType = pieceType;
        this.isBlack = isBlack;
        this.loc = loc;
    }

    //abstract methods
    public abstract boolean isLegalMove(Location loc);
    public abstract Set<Location> listPossibleMoves();

    //TODO: boolean borderCheck(Location loc){}

    //getters & setters
    public boolean isBlack() {return isBlack;}
    public PieceType getType() {return pieceType;}

    //helper methods
    //col_shift makes horizontal move, row_shift makes vertical move
    protected Set<Location> listLinearMoves(int col_shift, int row_shift) { //arg range {-1, 0, 1}
        Set<Location> set = new HashSet<>();
        char col_candidate = this.col;
        int row_candidate = this.row;
        col_candidate += col_shift;
        row_candidate += row_shift;
        while(col_candidate >= 'a' && col_candidate <= 'h' && row_candidate >= 1 && row_candidate <= 8)
        {
            if(board.isEmptyAt(col, row)) { //if candidate is empty
                set.add(Location(col, row));
            } else {    //if candidate is a piece
                if(board.at(col, row).isBlack != this.isBlack) { //if candidate is opponent
                    set.add(Location(col, row));
                } else {} //do nothing
                break;  //end search
            }
            col_candidate += col_shift;
            row_candidate += row_shift;
        }
        return set;
    }
}
