//ChessBoard.java

public class ChessBoard {
    private Piece[][] board = new Piece[8][8];    //board[col][row], loc[a-h][1-8]

    //constructor

    //methods
    Piece at(char col, int row) {
        return Piece[col - 'a'][row - 1];
    }
}
