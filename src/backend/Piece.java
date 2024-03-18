//Piece.java
package src.chess_game_backend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    //members
    //protected UUID
    protected boolean isBlack;
    protected PieceType pieceType;
    protected Location loc;
    protected boolean neverMoved = true;
    protected ChessBoard board; //reference to the board
    protected Set<Location> legalMoveList;  //current legal moves, valid untill next move is made; should be updated before each own turn

    //constructor
    protected Piece() {
        this(PieceType.Pawn, true);
    }
    protected Piece(PieceType pieceType, boolean isBlack) {
        this.pieceType = pieceType;
        this.isBlack = isBlack;
    }
    protected Piece(PieceType pieceType, boolean isBlack, Location loc) {
        this.pieceType = pieceType;
        this.isBlack = isBlack;
        this.loc = loc;
    }

    //abstract methods
    public abstract boolean isLegalMove(Location loc);
    //all locations that seems reachable, regardless of whether it will results in our King checked
    public abstract Set<Location> listNominalMoves();
    //AttackRange is not the exactly same as NominalMoves for: King Casting and Pawn
    public Set<Location> listAttackRange() {return listNominalMoves();}

    //TODO: boolean borderCheck(Location loc){}

    //getters & setters
    public Set<Location> getLegalMoveList() {
        return legalMovelist;}
    public boolean isBlack() {return isBlack;}
    public PieceType getType() {return pieceType;}
    public Location getLoc() {
        return loc;
    }
    public boolean isNeverMoved() {
        return neverMoved;
    }
    public void setMoved() {
        neverMoved = false;
    }

    //methods
    public void updateLegalMoveList() {
        legalMoveList.clear();  //is this line necessary?
        legalMoveList = listNominalMoves();
        //test if King is under attack by masking the board
        King selfKing = board.getKing(this.isBlack);
        board.setMaskSource(this.loc);  //mask Source
        legalMoveList.removeIf((Location m) -> {    //remove moves that results in ally King checked/attacked.
            board.setMastGoal(m);   //mask Goal as each candidate m
            return selfKing.isChecked();
        });
        board.clearMask();  //remember to clear the mask
    }

    //helper methods
    //col_shift makes horizontal move, row_shift makes vertical move
    protected Set<Location> listLinearMoves(int col_shift, int row_shift) { //arg range {-1, 0, 1}
        Set<Location> set = new HashSet<>();
        char col_candidate = this.col;
        int row_candidate = this.row;
        col_candidate += col_shift;
        row_candidate += row_shift;
        while(col_candidate >= 'a' && col_candidate <= 'h' && row_candidate >= 1 && row_candidate <= 8)
        {
            if(board.isEmptyAt(col, row)) { //if candidate is empty
                set.add(Location(col, row));
            } else {    //if candidate is a piece
                if(board.at(col, row).isBlack != this.isBlack) { //if candidate is opponent
                    set.add(Location(col, row));
                } else {} //do nothing
                break;  //end search
            }
            col_candidate += col_shift;
            row_candidate += row_shift;
        }
        return set;
    }
}
