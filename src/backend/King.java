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
        Set<Location> opponentGrossMoves = new HashSet<>;   //contains all locations under enemy attack
        for (Piece opponentPiece : board.getTeam(!this.isBlack))  //forEach piece in opponent team
        {
            opponentGrossMoves.addAll(opponentPiece.listNominalMoves());    //add current Piece's nominal moves to the Gross
        }
        return opponentGrossMoves.contains(this.loc);   //return true if contains self Location
    }
}
