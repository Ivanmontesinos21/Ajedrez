package Chess;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Board board=new Board();
        Coordinate c=new Coordinate('b',2);
        System.out.println(askCoordinate(board));
    }
    public static Coordinate askCoordinate(Board board) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Which piece do you want to move?");
        System.out.println("Enter a coordinate:");
        System.out.println(board);
        String coordenada = sc.next().toUpperCase();
       char letter= coordenada.charAt(0);
       int num=coordenada.charAt(1);
       boolean coordenadaValida=true;
        if (!coordenadaValida) {

            if (coordenada.length() != 2) {

                System.out.println("Introduce correctly where you want to put the piece");
                if (coordenada.charAt(0) >= 'A' && coordenada.charAt(0) <= 'H' && coordenada.charAt(1) >= 1 && coordenada.charAt(1) <= 9)
                    System.out.println("You had introduce the coordinate incorrectly " + "correctly form[A-2] for example");
            } else {

            }
        }

        return new Coordinate(letter, num);
    }



}

