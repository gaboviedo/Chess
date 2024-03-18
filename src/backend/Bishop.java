//Bishop.java
package src.chess_game_backend;

import java.util.Set;

public class Bishop extends Piece{
    //members

    //constructors
    Bishop(boolean isBlack, Location loc) {
        super(PieceType.Bishop, isBlack, loc);
    }

    //methods
    @Override
    Set<Location> listNominalMoves() {
        Set<Location> set = new HashSet<>();
        Location candidate;
        char col_candidate;
        int row_candidate;
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
