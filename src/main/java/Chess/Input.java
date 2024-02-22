package Chess;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Board board = new Board();
        Coordinate c = new Coordinate('b', 2);
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
}