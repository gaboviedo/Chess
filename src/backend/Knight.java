//Knight.java
package src.chess_game_backend;

import java.util.Set;

public class Knight extends Piece {
    //members

    //constructors
    Knight(boolean isBlack, Location loc) {
        super(PieceType.Knight, isBlack, loc);
    }

    //methods
    @Override
    Set<Location> listNominalMoves() {

        Set<Location> set=new HashSet<Location>();
        List<Location> possLocs=new ArrayList<Location>();
        possLocs.add(new Location((char) ((char)loc.getCol()-1),loc.getRow()-2 ));
        possLocs.add(new Location((char) ((char)loc.getCol()+1),loc.getRow()-2 ));
        possLocs.add(new Location((char) ((char)loc.getCol()-2),loc.getRow()-1 ));
        possLocs.add(new Location((char) ((char)loc.getCol()+2),loc.getRow()-1 ));
        for(int i = 0;i<possLocs.size();i++){
            if(board.contains(possLocs[i])){
            if(board.isEmptyAt(possLocs[i])){
                set.add(possLocs[i]);
            }}
        }
        return set;
    }
}
