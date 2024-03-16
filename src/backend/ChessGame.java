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
    boolean isBlackStalemate() {}
    boolean isWhiteStalemate() {}
    void removePiece(Location loc) {
        UUID uuid-toBeRemoved;
    }

    void setPiece(PieceType type, Location loc, boolean isBlack) {}
}
