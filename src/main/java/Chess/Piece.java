package Chess;

import com.diogonunes.jcolor.Attribute;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {
    private final String playerName;


    private final Type type;
    private Cell cell;

    public Piece(String playerName, Type type, Cell cell) {
        this.playerName = playerName;
        this.type = type;
        this.cell = cell;
        place();
    }

    protected void place() {
        if (cell != null)
            cell.setPiece(this);
    }

    protected boolean canAddToNextMovements(Coordinate c) {

        Board board = getCell().getBoard();

        if(!board.contains(c)) return false;

        if(board.getCellAt(c).isEmpty()) return true;

        return board.getCellAt(c).getPiece().getColor() != getColor();
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Type getType() {
        return type;
    }

    public Cell getCell() {
        return cell;
    }

    public Color getColor() {
        return type.getColor();
    }
    public Piece(String playerName, Type type) {
        this.type = type;
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }


    public abstract Set<Coordinate> getNextMovements();
    public boolean canMoveTo(Coordinate coordinate){
        Set<Coordinate>nextMovements=getNextMovements();
        return nextMovements.contains(coordinate);

    }

    public void remove(){
        if(cell!=null)
            cell.setPiece(null);
        cell = null;
    }

    public boolean moveTo(Coordinate coordinate){
        if(cell == null) return false;
        if(!canMoveTo(coordinate)) return false;

        Cell destination = cell.getBoard().getCellAt(coordinate);

        if(!destination.isEmpty())
            destination.getPiece().remove();

        cell.setPiece(null);
        cell = destination;

        place();

        return true;
    }

    @Override
    public String toString() {
        String resultado;

        if (cell == null) {
            resultado = colorize(type.getShape(), type.getColor().getAttribute());
        } else {
            resultado = colorize(type.getShape(), type.getColor().getAttribute(), cell.getColor().getAttribute());
        }
        return resultado;
    }

    public enum Color {

        WHITE(Attribute.BRIGHT_WHITE_TEXT()),
        BLACK(Attribute.TEXT_COLOR(0, 0, 0));

        private final Attribute color;

        Color(Attribute color) {
            this.color = color;
        }

        public Attribute getAttribute() {
            return color;
        }

    }

    public enum Type {

        WHITE_KING("♚", Color.WHITE),
        WHITE_QUEEN("♛", Color.WHITE),
        WHITE_ROOK("♜", Color.WHITE),
        WHITE_BISHOP("♝", Color.WHITE),
        WHITE_KNIGHT("♞", Color.WHITE),
        WHITE_PAWN("♟", Color.WHITE),
        BLACK_KING("♚", Color.BLACK),
        BLACK_QUEEN("♛", Color.BLACK),
        BLACK_ROOK("♜", Color.BLACK),
        BLACK_BISHOP("♝", Color.BLACK),
        BLACK_KNIGHT("♞", Color.BLACK),
        BLACK_PAWN("♟", Color.BLACK);

        private final String shape;
        private final Color color;

        Type(String shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public String getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }
    }

}