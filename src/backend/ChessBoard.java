//ChessBoard.java

public class ChessBoard {
    //members
    private Piece[][] board = new Piece[8][8];    //board[col][row], loc[a-h][1-8]
    private ArrayList<Piece> whiteTeam;
    private ArrayList<Piece> blackTeam;
    private King whiteKing;
    private King blackKing;

    //constructor

    //methods
    public Piece at(Location loc) {
        return at(loc.getCol(), loc.getRow());
    }
    public Piece at(char col, int row) {
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
}
