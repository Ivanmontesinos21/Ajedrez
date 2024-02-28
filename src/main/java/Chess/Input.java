package Chess;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Board board = new Board();

        askCoordinate(board);


        System.out.println(board);
    }

    public static Coordinate askCoordinate(Board board) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Which piece do you want to move?");
        System.out.println("Enter a coordinate:");
        System.out.println(board);
        String coordenada = sc.next().toUpperCase();

        char letter = coordenada.charAt(0);
        int num = Character.getNumericValue(coordenada.charAt(1));
        boolean coordenadaValida = true;

        if (coordenada.length() != 2 || letter < 'A' || letter > 'H' || num < 1 || num > 8) {
            System.out.println("Introduce the coordinate correctly (e.g., A2)");
            coordenadaValida = false;
        }

        while (!coordenadaValida) {
            System.out.println("Enter a valid coordinate:");
            coordenada = sc.next().toUpperCase();
            letter = coordenada.toUpperCase().charAt(0);
            num = Character.getNumericValue(coordenada.charAt(1));

            if (coordenada.length() == 2 && letter >= 'A' && letter <= 'H' && num >= 1 && num <= 8) {
                coordenadaValida = true;
            } else {
                System.out.println("Introduce the coordinate correctly (e.g., A2)");
            }
        }

        return new Coordinate(letter, num);
    }
}







