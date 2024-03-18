# This is a multi-client Chess game

## ToDo:
- [ ] add board reference to Piece class and sub class constructor
- [ ] rewrite King.listNominalMoves(), current one doesn't work
- [ ] implement ChessGame.setPiece()
- [ ] override listAttackRange() for Pawn and King
- [ ] override updateLegalMoveList() for Knight
- [ ] implement static method Location.isLegal(char, int), and delete borderCheck() from Piece.java
- [ ] implement setPiece(), removePiece(), promotion(), movePiece(), killPiece() in ChessGame.java
- [ ] unit test
    - [ ] Piece.updateLegalMoveList()
    - [ ] Piece.isLegalMove(Location)
    - [ ] Piece.listNominalMoves()
    - [ ] Piece.listAttackRange()
