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
    //methods
    public abstract boolean isLegalMove(Location loc);
    public abstract Set<Location> listPossibleMoves();
    //boolean borderCheck(Location loc){}
    public boolean isBlack() {return isBlack;}
    public PieceType getType() {return pieceType;}
}
