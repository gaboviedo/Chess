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
        return at(loc.getCol(), loc.getRow());
    }
    public Piece at(char col, int row) {
        if (col == maskSource.getCol() && row == maskSource.getRow()) {   //if query match mask source
            return null;
        }
        if (col == maskGoal.getCol() && row == maskGoal.getRow()) {   //if query match mask goal
            return Piece[mask_source.getCol() - 'a'][mask_source.getRow() - a]; //return source Piece
        }
        return Piece[col - 'a'][row - 1];
    }
    public boolean isEmptyAt(Location loc) {
        return isEmptyAt(loc.getCol(), loc.getRow());
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
