//ChessGame.java

public class ChessGame {
    private ChessBoard board;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;
    //private GameState stat;
    private boolean whiteIsChecked = false;
    private boolean blackIsChecked = false;
    private boolean whiteStalemate = false;
    private boolean blackStalemate = false;

    //constructor
    ChessGame() {
    }

    //methods
    boolean isBlackStalemate() {}
    boolean isWhiteStalemate() {}
    void removePiece(Location loc) {
    }
    void setPiece(PieceType type, Location loc) {}
}
