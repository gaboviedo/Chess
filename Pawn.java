package org.example;

public class Pawn extends Piece{

    //members
    protected enPassantEnabled = false; //can be killed by En Passant

    //constructor
    Pawn(Location loc, boolean isBlack) {
        pieceType = PieceType.Pawn;
        this.loc = loc;
        this.isBlack = isBlack;
    }

    //methods
    /**
     * list of conditions that would make a move not legal:
     *
     * @param targetLoc
     * @return
     */
    @Override
    boolean isLegalmove(Location targetLoc){
        if(targetLoc.getCol() != this.location.getCol()){
            return false;
            //todo: kill exception
        }
        if(isBlack){
            if(this.location.getRow()==7){
               return (this.location.getRow() > targetLoc.getRow()) && (this.location.getRow() - targetLoc.getRow() <= 2);
        }else{
                return (this.location.getRow() - targetLoc.getRow() == 1);
            }

        }
        else if () {

        }


    }
}
