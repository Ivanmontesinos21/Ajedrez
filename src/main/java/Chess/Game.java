package Chess;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Game game=new Game();
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

            return false;
    }

    }










