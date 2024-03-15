//Queen.java
package src.chess_game_backend;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece{
    //members

    //constructor
    Queen(Location loc,boolean isBlack ){
        super(PieceType.Pawn, isBlack);
        this.loc = loc;
    }

    //methods
    @Override
    boolean isLegalMove(Location targetLoc){
        if((targetLoc.getCol()-loc.getCol())==(targetLoc.getRow()- loc.getRow())){//defines diagonal movement
            return true;
        }
        else if(targetLoc.getCol()== loc.getCol()&&targetLoc.getRow()!=loc.getRow()){//defines vertical movement
            return true;
        }
        else if(targetLoc.getCol()!= loc.getCol()&&targetLoc.getRow()==loc.getRow()){//defines hori movement
            return true;
        }
        return false;
    }
    @Override
    Set<Location> listPossibleMoves() {
        //TODO
    }
}
