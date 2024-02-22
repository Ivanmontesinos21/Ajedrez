package Chess;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Board board = new Board();
        Coordinate c = new Coordinate('b', 2);
        placePieces( board);
        System.out.println(askCoordinate(board));
    }

    public static Coordinate askCoordinate(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which piece do you want to move?");
        System.out.println("Enter a coordinate:");
        System.out.println(board);
        String coordenada = sc.next().toUpperCase();
        char letter = coordenada.charAt(0);
        int num = 0;

        // Verificar si la longitud de la entrada es válida
        if (coordenada.length() != 2 || coordenada.charAt(0) < 'A' || coordenada.charAt(0) > 'H' || coordenada.charAt(1) < '1' || coordenada.charAt(1) > '8') {
            System.out.println("Please enter a valid coordinate in the format [A-H][1-8].");
            return askCoordinate(board); // Llamada recursiva para pedir otra coordenada
        } else {
            num = Character.getNumericValue(coordenada.charAt(1)); // Convertir el segundo carácter a un valor numérico
        }

        return new Coordinate(letter, num);

    }
    private static void placePieces( Board board) {
        // Coloca las piezas blancas
        board.getCellAt(new Coordinate('A', 1)).setPiece(new Rook(board, new Coordinate('A', 1), Rook.Type.WHITE));
        board.getCellAt(new Coordinate('B', 1)).setPiece(new Knight(board, new Coordinate('B', 1), Knight.Type.WHITE));
        board.getCellAt(new Coordinate('C', 1)).setPiece(new Bishop(board, new Coordinate('C', 1), Bishop.Type.WHITE));
        board.getCellAt(new Coordinate('D', 1)).setPiece(new Queen(board, new Coordinate('D', 1), Queen.Type.WHITE));
        board.getCellAt(new Coordinate('E', 1)).setPiece(new King(board, new Coordinate('E', 1), King.Type.WHITE));
        board.getCellAt(new Coordinate('F', 1)).setPiece(new Bishop(board, new Coordinate('F', 1), Bishop.Type.WHITE));
        board.getCellAt(new Coordinate('G', 1)).setPiece(new Knight(board, new Coordinate('G', 1), Knight.Type.WHITE));
        board.getCellAt(new Coordinate('H', 1)).setPiece(new Rook(board, new Coordinate('H', 1), Rook.Type.WHITE));

        for (char col = 'A'; col <= 'H'; col++) {
            board.getCellAt(new Coordinate(col, 2)).setPiece(new Pawn(board, new Coordinate(col, 2), Pawn.Type.WHITE));
        }

        // Coloca las piezas negras
        board.getCellAt(new Coordinate('A', 8)).setPiece(new Rook(board, new Coordinate('A', 8), Rook.Type.BLACK));
        board.getCellAt(new Coordinate('B', 8)).setPiece(new Knight(board, new Coordinate('B', 8), Knight.Type.BLACK));
        board.getCellAt(new Coordinate('C', 8)).setPiece(new Bishop(board, new Coordinate('C', 8), Bishop.Type.BLACK));
        board.getCellAt(new Coordinate('D', 8)).setPiece(new Queen(board, new Coordinate('D', 8), Queen.Type.BLACK));
        board.getCellAt(new Coordinate('E', 8)).setPiece(new King(board, new Coordinate('E', 8), King.Type.BLACK));
        board.getCellAt(new Coordinate('F', 8)).setPiece(new Bishop(board, new Coordinate('F', 8), Bishop.Type.BLACK));
        board.getCellAt(new Coordinate('G', 8)).setPiece(new Knight(board, new Coordinate('G', 8), Knight.Type.BLACK));
        board.getCellAt(new Coordinate('H', 8)).setPiece(new Rook(board, new Coordinate('H', 8), Rook.Type.BLACK));

        for (char col = 'A'; col <= 'H'; col++) {
            board.getCellAt(new Coordinate(col, 7)).setPiece(new Pawn(board, new Coordinate(col, 7), Pawn.Type.BLACK));
        }
    }
}