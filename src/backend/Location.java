//Location.java
package src.chess_game_backend;

public class Location {
    char col;
    int row;

    //constructor
    Location(char col, int row) {
	    this.col = col;
	    this.row = row;
    }

    int getRow(){
        return this.row;
    }
    char getCol(){
        return this.col;
    }

    public void setCol(char col) {
        if(col < 'a' || col > 'h') {
            //TODO: throw exception illegal arg
        }
        this.col = col;
    }

    public void setRow(int row) {
        if(row < 1 || row > 8) {
            //TODO: throw illegal arg
        }
        this.row = row;
    }
    public void set(char col, int row) {
        setCol(col);
        setRow(row);
    }
}
