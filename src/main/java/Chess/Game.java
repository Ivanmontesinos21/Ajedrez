package Chess;

import java.util.Map;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }

    private final Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game() {
        board = new Board();
     initializeBoard();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1:");
        player1 = new Player(scanner.nextLine(), Player.Color.WHITE);
        System.out.println("Ingrese el nombre del jugador 2:");
        player2 = new Player(scanner.nextLine(), Player.Color.BLACK);

        currentPlayer = player1; // Comienza el juego con el jugador 1
    }

    private void initializeBoard() {
        // Código de inicialización del tablero aquí
    

    }

public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver()) {
            System.out.println(board);
            System.out.println("Turno de " + currentPlayer.getName());

            // Solicitar al jugador que ingrese la coordenada de la pieza que desea mover
            System.out.println("Introduce the coordinate you want to move (for exemple, b3)");
            Coordinate from = Input.askCoordinate(board);

            // Verificar si la coordenada ingresada es válida
            if (!board.contains(from) || board.getCellAt(from).isEmpty() || !board.getCellAt(from).getPiece().equals(currentPlayer.getName())) {
                System.out.println("Succesfull movement");

            }

            // Solicitar al jugador que ingrese la coordenada a la que desea mover la pieza
            System.out.println("Introduce the coordinate you want to move (for exemple, b3):");
            Coordinate to = Input.askCoordinate(board);

            // Verificar si el movimiento es válido y realizarlo si es así
            if (board.getCellAt(from).getPiece().moveTo(to)) {
                System.out.println("Succesfull movement");
            } else {
                System.out.println("invalid move. try again.");

            }

            // Cambiar al siguiente jugador
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }


    }

    private boolean isGameOver() {
        int numRows = 8;
        int numCols = 8;
        Map<Coordinate,Cell> cells=board.getCells();
        // Itera sobre todas las celdas del tablero
        for (int row = 1; row <= numRows; row++) {
            for (char col = 'A'; col <= 'H'; col++) {
                Coordinate currentCoord = new Coordinate(col, row);
                Cell currentCell = cells.get(currentCoord);
                if (currentCell != null && !currentCell.isEmpty()) {
                    Piece piece = currentCell.getPiece();
                    // Si la pieza en la celda es un rey y no pertenece al jugador actual, el juego ha terminado
                    if (piece instanceof King && !piece.getColor().equals(currentPlayer.getColor())) {
                        return true;
                    }
                }
            }
        }
        return false; // Si no se encuentra ningún rey del oponente capturado
    }
    public  void placePieces(Board board) {
        //Place Black Pieces

        for (int i='A';i<='H';i++) {
            new Pawn(board, new Coordinate((char) i, 2), Pawn.Type.BLACK);
        }
        Rook   blackRook1=new Rook(board,new Coordinate('A',1), Rook.Type.BLACK);
        Rook blackRook2=new Rook(board,new Coordinate('H',1), Rook.Type.BLACK);
        Knight blackKnight1=new Knight(board,new Coordinate('B',1), Knight.Type.BLACK);
        Knight blackKnight2=new Knight(board,new Coordinate('G',1), Knight.Type.BLACK);
        Bishop blackBishop1=new Bishop(board,new Coordinate('C',1), Bishop.Type.BLACK);
        Bishop blackBishop2=new Bishop(board,new Coordinate('F',1), Bishop.Type.BLACK);
        King  blackKing=new King(board,new Coordinate('E',1), King.Type.BLACK);
        Queen blackQueen=new Queen(board,new Coordinate('D',1), Queen.Type.BLACK);


        // Place White Pieces

        for (int i='A';i<='H';i++) {
            new Pawn(board, new Coordinate((char) i, 7), Pawn.Type.WHITE);
        }
        Rook   whiteRook1=new Rook(board,new Coordinate('A',8), Rook.Type.WHITE);
        Rook whiteRook2=new Rook(board,new Coordinate('H',8), Rook.Type.WHITE);
        Knight whiteKnight1=new Knight(board,new Coordinate('B',8), Knight.Type.WHITE);
        Knight whiteKnight2=new Knight(board,new Coordinate('G',8), Knight.Type.WHITE);
        Bishop whiteBishop1=new Bishop(board,new Coordinate('C',8), Bishop.Type.WHITE);
        Bishop whiteBishop2=new Bishop(board,new Coordinate('F',8), Bishop.Type.WHITE);
        King  whiteKing=new King(board,new Coordinate('E',8), King.Type.WHITE);
        Queen whiteQueen=new Queen(board,new Coordinate('D',8), Queen.Type.WHITE);




    }
}











