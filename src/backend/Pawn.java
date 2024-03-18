//Pawn.java
package src.chess_game_backend;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece{

    //members
    protected enPassantEnabled = false; //can be killed by En Passant

    //constructor
    Pawn(boolean isBlack, Location loc) {
        super(PieceType.Pawn, isBlack, loc);
    }

    //methods override
    @Override
    Set<Location> listNominalMoves() {
        Set<Location> set = new HashSet<>();
        Location candidate;
        Piece sidePiece;

        //check lack of promotion
        if(this.isBlack() == true && this.loc.getRow() <= 1) || (this.sBlack() == false && this.loc.getRow() >= 8) {    //if at opponent border
            //TODO: throw exception. why has it not be promoted
        }
        //add normal moves
        candidate = new Location(col, row + (isBlack() ? -1 : 1));
        if(board.isEmptyAt(candidate)) {
            set.add(candidate);
            if(neverMoved) {
                candidate = new Location(col, row + (isBlack() ? -2 : 2));
                if(board.isEmptyAt(candidate)) {
                    set.add(candidate);
                }
            }
        }
        //add kill move
          //left kill
        set.add(listKillMoves(true));
          //right kill
        set.add(listKillMoves(false));
        return set;
    }

    //methods
    private Set<Location> listKillMoves(boolean leftKill) {
        int colShift = leftKill ? -1 : 1;
        Set<Location> set = new HashSet<>();
        Location candidate;
        Piece sidePiece;
        if((leftKill && col > 'a') || (!leftKill && col < 'h')) {
            candidate = new Location(col + colShift, row + (isBlack() ? -1 : 1));
            if(board.isEmptyAt(candidate)) {    //if candidate is empty
                //En Passant
                sidePiece = board.at(col + colShift, row);
                if(sidePiece.getType == PieceType.Pawn && sidePiece.isBlack() != isBlack()) {   //if sidePiece is enemy Pawn
                    if(sidePiece.enPassantEnabled()) {
                        set.add(candidate);
                    }
                }
            } else {    //if candidate is not empty
                //normal kill
                if(board.at(candidate).isBlack() != isBlack()) {    //if candidate is an enemy
                    set.add(candidate);
                }
            }
        }
        return set;
    }
}
