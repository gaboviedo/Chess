//Queen.java
package src.chess_game_backend;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece{
    //members

    //constructor
    Queen(boolean isBlack, Location loc) {
        super(PieceType.Queen, isBlack, loc);
    }

    //methods
    @Override
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
