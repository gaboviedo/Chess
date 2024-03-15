//King.java
package src.chess_game_backend;

import java.util.Set;
import static java.lang.Math.abs;

public class King extends Piece{
    //members

    //consturctors
    King(Location loc,boolean isBlack ){
        super(PieceType.Pawn, isBlack);
        this.loc = loc;
    }

    //methods
    @Override
    boolean isLegalMove(Location targetLoc){
        if(abs(targetLoc.getCol()-loc.getCol())==1&&1==abs(targetLoc.getRow()- loc.getRow())){//defines diagonal movement by 1
            return true;
        }
        else if(targetLoc.getCol()== loc.getCol()&&abs(targetLoc.getRow()-loc.getRow())==1){//defines vertical movement by 1
            return true;
        }
        else if(1==abs(targetLoc.getCol()- loc.getCol())&&targetLoc.getRow()==loc.getRow()){//defines hori movement by 1
            return true;
        }
        return false;
    }

    @Override
    Set<Location> listPossibleMoves() {
        //TODO
    }
}

}