package Chess;

import java.util.HashSet;
import java.util.Set;

public  class Bishop extends Piece {
    public Bishop(Board board, Coordinate position, Bishop.Type type) {
        super(type.getType(), board.getCellAt(position));
    }
    public Set<Coordinate> getNextMovements(){
        return getNextMovementsAsBishop(this);
    }

    public  static Set<Coordinate> getNextMovementsAsBishop(Piece piece) {

        Set<Coordinate> nextMovements=new HashSet<>();
        Coordinate posicion = piece.getCell().getCoordinate();
        Coordinate c;
        Board board = piece.getCell().getBoard();

        // Comprobamos que la ficha este en el tablero
        if (posicion == null)
            return nextMovements;

        // diagonal superior izquierda
        c = posicion;
        do {
            c = c.up().left();
            if (piece.canAddToNextMovements(c))
               nextMovements.add(c);

        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        // diagonal superior derecha
        c = posicion;
        do {
            c = c.up().right();
            if (piece.canAddToNextMovements(c))
                nextMovements.add(c);

        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        // diagonal inferior izquierda
        c = posicion;
        do {
            c = c.down().left();
            if (piece.canAddToNextMovements(c))
                nextMovements.add(c);

        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        // diagonal inferior derecha
        c = posicion;
        do {
            c = c.down().right();
            if (piece.canAddToNextMovements(c))
                nextMovements.add(c);

        } while (board.contains(c) && board.getCellAt(c).isEmpty());

        return nextMovements;
    }


    //put your task here

    public enum Type {
        BLACK(Piece.Type.BLACK_BISHOP), WHITE(Piece.Type.WHITE_BISHOP);
        private final Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
