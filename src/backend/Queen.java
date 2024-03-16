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
        Set<Location> set = new HashSet<>();
        Location candidate;
        char col_candidate;
        int row_candidate;
        //going upward
        set.addAll(listLinearMoves(0, 1));
        //going downward
        set.addAll(listLinearMoves(0, -1));
        //going left
        set.addAll(listLinearMoves(-1, 0));
        //going right
        set.addAll(listLinearMoves(1, 0));
        //diagonal 1
        set.addAll(listLinearMoves(1, 1));
        //diagonal 2
        set.addAll(listLinearMoves(-1, 1));
        //diagonal 3
        set.addAll(listLinearMoves(-1, -1));
        //diagonal 4
        set.addAll(listLinearMoves(1, -1));
        return set;
    }
}
