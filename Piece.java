package org.example;

import java.util.ArrayList;

public abstract class Piece {
    //members
    //protected UUID
    protected boolean isBlack;
    protected PieceType pieceType;
    protected Location loc;
    protected neverMoved = true;
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
    public abstract boolean isLegalMove(Location loc){}
    public abstract Set<Location> listPossibleMoves(){}
    //boolean borderCheck(Location loc){}
    public boolean isBlack() {return isBlack;}
    public PieceType getType() {return pieceType;}


}
