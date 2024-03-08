package org.example;

public class Pawn extends Piece{

    //members
    protected enPassantEnabled = false; //can be killed by En Passant

    //constructor
    Pawn(Location loc, boolean isBlack) {
        super(PieceType.Pawn, isBlack);
        this.loc = loc;
    }

    //methods override
    /**
     * list of conditions that would make a move not legal:
     *
     * @param targetLoc
     * @return
     */
    @Override
    boolean isLegalmove(Location targetLoc){
        if(targetLoc.getCol() != this.location.getCol()){
            return false;
            //todo: kill exception
        }
        if(isBlack){
            if(this.location.getRow()==7){
               return (this.location.getRow() > targetLoc.getRow()) && (this.location.getRow() - targetLoc.getRow() <= 2);
        }else{
                return (this.location.getRow() - targetLoc.getRow() == 1);
            }

        }
        else if () {

        }
    }

    @Override
    Set<Location> listPossibleMoves() {
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
