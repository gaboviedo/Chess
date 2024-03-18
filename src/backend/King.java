//King.java
package src.chess_game_backend;

import java.util.Set;
import static java.lang.Math.abs;

public class King extends Piece{
    //members

    //consturctors
    King(boolean isBlack, Location loc) {
        super(PieceType.King, isBlack, loc);
    }

    //methods
    @Override
    Set<Location> listNominalMoves() {
        Set<Location> set=new HashSet<Location>();
        List<Location> posschanges=new ArrayList<Location>();
        // positive diagnol
        posschanges.add(-1,-1);
        posschanges.add(1,1);
        //negative diagnol
        posschanges.add(-1,1);
        posschanges.add(1,-1);

        posschanges.add(0,1);
        posschanges.add(1,0);
        posschanges.add(-1,0);
        posschanges.add(0,-1);
        for (int i=0;i<posschanges.size();i++) {
            Location candidate = new Location((char)loc.getCol()+posschanges[i].getCol,loc.getRow()+posschanges[i].getRow());
            if (board.contains(candidate)){
                if (board.isEmptyAt(candidate)){
                    set.add(candidate);
                } else {
                    if (board.at(col, row).isBlack != this.isBlack){
                        set.add(candidate);
                    }
                }
            }
            return set;
        }
    }

    public boolean isChecked() {
        for (Piece opponentPiece : board.getTeam(!this.isBlack))  //forEach piece in opponent team
        {
            //if anyone's AttackRange contains King's loc, then King is checked
            if (opponentPiece.listAttackRange().contains(this.loc)) {return true;}
        }
        return false;
    }
}
