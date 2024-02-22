package Chess;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Board board=new Board();


        placePieces(board);
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
            letter = coordenada.charAt(0);
            num = Character.getNumericValue(coordenada.charAt(1));

            if (coordenada.length() == 2 && letter >= 'A' && letter <= 'H' && num >= 1 && num <= 8) {
                coordenadaValida = true;
            } else {
                System.out.println("Introduce the coordinate correctly (e.g., A2)");
            }
        }

        return new Coordinate(letter, num);
    }
    public static void placePieces(Board board) {
      //implementar poner las piezas
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


         // Place Black Pieces

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







