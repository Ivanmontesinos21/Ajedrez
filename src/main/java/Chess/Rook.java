package Chess;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {
    public Rook(Board board, Coordinate position, Rook.Type type) {
        super(type.getType(), board.getCellAt(position));
    }
    public Set<Coordinate> getNextMovements(){
        return getNextMovementsAsRook(this);
    }

    //put your task here
    public static Set<Coordinate> getNextMovementsAsRook(Piece piece) {


        Set<Coordinate> nextMovements=new HashSet<>();
        Coordinate posicion = piece.getCell().getCoordinate();
        Coordinate c;
        Board board = piece.getCell().getBoard();

        // Comprobamos que la ficha este en el tablero
        if (posicion == null)
            return nextMovements;

        // diagonal arriba
        c = posicion;
        do {
            c = c.up();
            if (piece.canAddToNextMovements(c))
                nextMovements.add(c);
        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        // Diagonal hacia la derecha
        c = posicion;
        do {
            c = c.right();
            if (piece.canAddToNextMovements(c))
                nextMovements.add(c);
        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        // diagonal hacia la izquierda
        c = posicion;
        do {
            c = c.left();
            if (piece.canAddToNextMovements(c))
                nextMovements.add(c);
        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        // diagonal  hacia abajo
        c = posicion;
        do {
            c = c.down();
            if (piece.canAddToNextMovements(c))
                nextMovements.add(c);
        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_ROOK), WHITE(Piece.Type.WHITE_ROOK);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}