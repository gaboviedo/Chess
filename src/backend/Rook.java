package src.chess_game_backend;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    Rook(Location loc,boolean isBlack ){
        super(PieceType.Pawn, isBlack);
        this.loc = loc;
    }
    @Override
    boolean isLegalMove(Location targetLoc){
        if(targetLoc.getCol()== loc.getCol()&&targetLoc.getRow()!=loc.getRow()){//defines vertical movement
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
        Location candidate=new Location(loc.getCol(), loc.getRow());
        for(int i= loc.getCol();i<8;i++) {//checks right
            candidate.setCol((char)i);
        if(board.isEmptyAt(candidate)){
            set.add(candidate);
        }
        if(loc.getCol()!='a'){
            for(int j=loc.getCol();j>'a';j--){//checks left
                candidate.setCol((char) i);
                if(board.isEmptyAt(candidate)){
                    set.add(candidate);
            }}
        for(int k=loc.getRow();k<8;k++){//checks up
            candidate.setRow(k);
            if(board.isEmptyAt(candidate)){
                set.add(candidate);
            }
        }
        if(loc.getRow()!=1){
            for(int k=loc.getRow();k>0;k--){//checks down
                candidate.setRow(k);
                if(board.isEmptyAt(candidate)){
                    set.add(candidate);
                }
            }
        }
        return set;
        }



}
