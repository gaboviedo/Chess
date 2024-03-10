package src.chess_game_backend;

import java.util.Set;

public class Bishop extends Piece{
    Bishop(Location loc,boolean isBlack ){
        super(PieceType.Pawn, isBlack);
        this.loc = loc;
    }
    @Override
    boolean isLegalMove(Location targetLoc){
        if((targetLoc.getCol()-loc.getCol())==(targetLoc.getRow()- loc.getRow())){//defines diagonal movement
            return true;
        }
        return false;
    }
    @Override
    Set<Location> listPossibleMoves() {
        return;
    }
}
