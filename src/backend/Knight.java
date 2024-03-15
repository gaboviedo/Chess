//Knight.java
package src.chess_game_backend;

import java.util.Set;
import static java.lang.Math.abs;

public class Knight extends Piece{
    //members

    //constructors
    Knight(Location loc,boolean isBlack ){
        super(PieceType.Pawn, isBlack);
        this.loc = loc;
    }

    //methods
    @Override
    boolean isLegalMove(Location targetLoc){
        if(1==abs(targetLoc.getCol()- loc.getCol())&&abs(targetLoc.getRow()-loc.getRow())==2){//tall L
            return true;
        }
        else if(2==abs(targetLoc.getCol()- loc.getCol())&&abs(targetLoc.getRow()-loc.getRow())==1){//short L
            return true;
        }
        return false;
    }

    @Override
    Set<Location> listPossibleMoves() {
        Location candidate = new Location((char) ((char)loc.getCol()-2),loc.getRow()-3 );
        for(int i = 0;i<4;i++){
            if(board.isEmpty(candidate)){
                set.add
            }
        }
        return;
    }
}
