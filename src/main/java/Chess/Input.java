package Chess;

import java.util.Scanner;

public class Input {
    public static Coordinate askCoordinate(Board board, boolean uTurn) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which piece do you want to move?");
        System.out.println("Enter a coordinate:");
        System.out.println(board);
        String coordenada = sc.next();
        char letter = coordenada.charAt(0);
        int num = coordenada.charAt(1);
        if (coordenada.length() != 2 ) {
            System.out.println("Introduce correctly where you want to put the piece");
        } else {

        }
        return new Coordinate(letter, num);
    }




}

