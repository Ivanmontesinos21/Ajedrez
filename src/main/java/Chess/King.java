package Chess;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        Set<Coordinate>nextMovements=new HashSet<>();
        Coordinate position = getCell().getCoordinate();

            //up+

        if (canAddToNextMovements(position.up()))
            nextMovements.add(position.up());
            //upRight
        if (canAddToNextMovements(position.up().right()))
            nextMovements.add(position.up().right());
            //right
        if (canAddToNextMovements(position.right()))
            nextMovements .add(position.right());
            //downRight

        if (canAddToNextMovements(position.down().right()))
            nextMovements.add(position.down().right());
            //down
        if (canAddToNextMovements(position.down()))
            nextMovements.add(position.down());

            //downLeft
        if (canAddToNextMovements(position.down().left()))
           nextMovements.add(position.down().left());
            //left
        if (canAddToNextMovements(position.left()))
            nextMovements.add(position.left());

            //upLeft
        if (canAddToNextMovements(position.up().left()))
            nextMovements.add(position.up().left());

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_KING), WHITE(Piece.Type.WHITE_KING);
        private final Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
