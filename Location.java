package org.example;

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
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
