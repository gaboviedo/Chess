//Rook.java
package src.chess_game_backend;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    //members

    //constructors
    Rook(boolean isBlack, Location loc) {
        super(PieceType.Rook, isBlack, loc);
    }

    //methods
    @Override
    /*Set<Location> listNominalMoves() {
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
     */
    Set<Location> listNominalMoves() {
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
        return set;
    }
}
