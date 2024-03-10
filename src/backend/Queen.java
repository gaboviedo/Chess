package src.chess_game_backend;

import java.util.Set;

public class Queen extends Piece{
    Queen(Location loc,boolean isBlack ){
        super(PieceType.Pawn, isBlack);
        this.loc = loc;
    }
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
        return;
    }
}
