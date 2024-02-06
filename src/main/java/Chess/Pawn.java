package Chess;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        if (getColor() == Color.BLACK)
            return getNextMovementsAsBlack();
        else
            return getNextMovementsAsWhite();
    }

    private Set<Coordinate> getNextMovementsAsWhite() {
//        Coordinate[] nextMovements = new Coordinate[0];
        Set<Coordinate> nextMovements=new HashSet<>();
        Coordinate c;
        Coordinate position = getCell().getCoordinate();
        Board board = getCell().getBoard();

        // posicion delante
        c = position.up();

        if (board.contains(c) && board.getCellAt(c).isEmpty())
            nextMovements.add(c);

        // avanza matando
        c = position.up().left();
        if (board.contains(c) && (!board.getCellAt(c).isEmpty() && board.getCellAt(c).getPiece().getColor() != getColor()))
            nextMovements.add(c);

        c = position.up().right();
        if (board.contains(c) && (!board.getCellAt(c).isEmpty() && board.getCellAt(c).getPiece().getColor() != getColor()))
            nextMovements.add(c);

        // Si esta en la posicion inicial se le permite avanzar 2 posiciones
        if (position.getNumber() == 7) {
            c = position.up();
            if (board.contains(c) && board.getCellAt(c).isEmpty()) {
                c = position.up();
                if (board.contains(c) && board.getCellAt(c).isEmpty()) {
                    nextMovements.add(c);
                }
            }
        }
        return nextMovements;
    }

    private Set<Coordinate> getNextMovementsAsBlack() {
        Set<Coordinate>nextMovements=new HashSet<>();
        Coordinate c;
        Coordinate position = getCell().getCoordinate();
        Board board = getCell().getBoard();

        // posicion delante
        c = position.down();

        if (board.contains(c) && board.getCellAt(c).getPiece() == null)
            nextMovements.add(c);

        // avanza matando
        c = position.down().left();
        if (!board.getCellAt(c).isEmpty()&& board.getCellAt(c).getPiece().getColor() != getColor())
            nextMovements.add(c);

        c = position.down().right();
        if (!board.getCellAt(c).isEmpty() && board.getCellAt(c).getPiece().getColor() != getColor())
            nextMovements.add(c);

        // Si esta en la posicion inicial se le permite avanzar 2 posiciones
        if (position.getNumber() == 2)
            c = position.down();
        if (board.contains(c) && board.getCellAt(c).isEmpty()) {
            c = position.down();
            if (board.contains(c) && board.getCellAt(c).isEmpty()) {
                nextMovements.add(c);
            }
        }

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_PAWN), WHITE(Piece.Type.WHITE_PAWN);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
