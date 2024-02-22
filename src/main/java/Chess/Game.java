package Chess;

import java.util.Scanner;

public class Game {

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
            System.out.println("Ingrese la coordenada de la pieza que desea mover (por ejemplo, A2):");
            Coordinate from = Input.askCoordinate(board);

            // Verificar si la coordenada ingresada es válida
            if (!board.contains(from) || board.getCellAt(from).isEmpty() || !board.getCellAt(from).getPiece().getPlayerName().equals(currentPlayer.getName())) {
                System.out.println("Movimiento inválido. Intente nuevamente.");
                continue;
            }

            // Solicitar al jugador que ingrese la coordenada a la que desea mover la pieza
            System.out.println("Ingrese la coordenada a la que desea mover la pieza (por ejemplo, B3):");
            Coordinate to = Input.askCoordinate(board);

            // Verificar si el movimiento es válido y realizarlo si es así
            if (board.getCellAt(from).getPiece().moveTo(to)) {
                System.out.println("Movimiento realizado con éxito.");
            } else {
                System.out.println("Movimiento inválido. Intente nuevamente.");
                continue;
            }

            // Cambiar al siguiente jugador
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }

        // Mostrar el resultado del juego
        String winner = determineWinner();
        if (winner != null) {
            System.out.println("Fin del juego. El ganador es " + winner);
        } else {
            System.out.println("Fin del juego. Es un empate.");
        }
    }

        private boolean isGameOver() {
            // Verifica si el rey de uno de los jugadores ha sido capturado
            return determineWinner() != null;
        }

    private String determineWinner() {
        for (int row = 1; row <= 8; row++) {
            for (char col = 'A'; col <= 'H'; col++) {
                Coordinate coordinate = new Coordinate(col, row);
                Cell cell = board.getCellAt(coordinate);
                Piece piece = cell.getPiece();
                if (piece instanceof King && piece.getPlayerName() != null) {
                    return piece.getPlayerName();
                }
            }
        }
        return null; // No se ha capturado ningún rey
    }

        public static void main(String[] args) {
            Game game = new Game();
            game.play();
        }
}
