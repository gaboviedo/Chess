package org.example;

import java.util.ArrayList;

public abstract class Piece {
    boolean isBlack;
    protected String pieceType;
    protected Location location;
    //abstract
    void move(Location loc){

    }
    //abstract
    boolean isLegalMove(Location loc){}
    ArrayList<Location> listPossibleMoves(Location loc){
        //implement here
    }
    boolean borderCheck(Location loc){}



}
