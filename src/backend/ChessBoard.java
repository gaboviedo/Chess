//ChessBoard.java

public class ChessBoard {
    //members
    private Piece[][] board = new Piece[8][8];    //board[col][row], loc[a-h][1-8]
    private ArrayList<Piece> whiteTeam;
    private ArrayList<Piece> blackTeam;
    private King whiteKing;
    private King blackKing;

    private Location maskSource;
    private Location maskGoal;

    //constructor

    //methods
    public Piece at(Location loc) {
        if (loc == maskSource) {    //if query location match maskSource
            return null;
        }
        if (loc == maskGoal) {      //if query location match maskGoal
            return Piece[mask_source.getCol() - 'a'][mask_source.getRow() - a]; //return source Piece
        }
        return Piece[loc.getCol() - 'a'][loc.getRow() - 1]; //return unmasked Piece
    }
    public Piece at(char col, int row) {
        if (col == maskSource.getCol() && row == maskSource.getRow()) { //if query location match mask source
            return null;
        }
        if (col == maskGoal.getCol() && row == maskGoal.getRow()) {     //if query location match mask goal
            return Piece[mask_source.getCol() - 'a'][mask_source.getRow() - a]; //return source Piece
        }
        return Piece[col - 'a'][row - 1];   //return unmasked Piece
    }
    public boolean isEmptyAt(Location loc) {
        if (at(loc) == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isEmptyAt(char col, int row) {
        if (at(col, row) == null) {
            return true;
        } else {
            return false;
        }
    }

    public void setMaskSource(Location loc) {
        maskSource = loc;
    }
    public void setMaskSource(char col, int row) {
        maskSource = new Location(col, row);
    }
    public void setMaskGoal(Location loc) {
        maskGoal = loc;
    }
    public void setMaskGoal(char col, int row) {
        maskGoal = new Location(col, row);
    }
    public void clearMask() {
        maskSource = null;
        maskGoal = null;
    }

    public King getKing(boolean isBlack) {
        if (isBlack) {
            return blackKing;
        }
        return whiteKing;
    }
    public ArrayList<Piece> getTeam(boolean isBlack) {
        if (isBlack) {
            return blackTeam;
        }
        return whiteTeam;
    }
}
