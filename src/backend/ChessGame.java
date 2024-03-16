//ChessGame.java

public class ChessGame {
    private ChessBoard board;
    //private deadPieces;
    //private GameState status;
    private boolean whiteIsChecked = false;
    private boolean blackIsChecked = false;
    private boolean whiteStalemate = false;
    private boolean blackStalemate = false;

    //constructor
    ChessGame() {
    }

    //methods
    void move(Piece piece, Location targetLoc) {};
    public boolean isStalemated(boolean isBlack) {
        ArrayList<Piece> team = board.getTeam(isBlack);
        for (Piece piece : team)
        {
            //piece.updateLegalMoveList();  //recommend to call updateLegalMoveList() before call this, in game loop
            if (!piece.getLegalMoveList().isEmpty())    //if not empty; aka this piece can move
            {
                return false;
            }
        }
        return true;
    }
    void removePiece(Location loc) {
        UUID uuid-toBeRemoved;
    }

    void setPiece(PieceType type, Location loc, boolean isBlack) {}
}
