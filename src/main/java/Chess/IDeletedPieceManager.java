package Chess;

public interface IDeletedPieceManager {
    void  addPiece(Piece piece);
    Piece removeLast();
    int count(Piece.Type type);

}

