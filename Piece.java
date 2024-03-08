package org.example;

import java.util.ArrayList;

public abstract class Piece {
    //members
    //protected UUID
    boolean isBlack;
    protected PieceType pieceType;
    protected Location location;
    protected neverMoved = true;

    //methods
    //abstract
    void move(Location loc){

    }
    //abstract
    boolean isLegalMove(Location loc){}
    ArrayList<Location> listPossibleMoves(Location loc){
        //implement here
    }
    //boolean borderCheck(Location loc){}



}
