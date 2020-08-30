package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------");
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.print("---------");
        System.out.println();
        int column = 0, row = 0;
        boolean isX = true;
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                String input = scanner.nextLine();
                Scanner scan = new Scanner(input);
                int a = scan.nextInt();
                int b = scan.nextInt();
                column = a;
                row = b;

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (column <= 0 || row <= 0 || column >= 4 || row >= 4) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            switch (row) {
                case 1:
                    row = 2;
                    break;
                case 2:
                    row = 1;
                    break;
                case 3:
                    row = 0;
                    break;

            }
            switch (column) {
                case 1:
                    column = 0;
                    break;
                case 2:
                    column = 1;
                    break;
                case 3:
                    column = 2;
                    break;

            }
            if (matrix[row][column] == ' ') {
                if (isX) {
                    matrix[row][column] = 'X';
                } else if(isX==false) {
                    matrix[row][column] = 'O';
                }
                showMatrix(matrix);
                if (isFinalGame(matrix)) {
                    break;
                }
                if (isX) {
                    isX = false;
                } else {
                    isX = true;
                }
                continue;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
        }


        //isFinalGame(matrix);


    }


    public static boolean isXWin(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

            }
        }
        if (matrix[0][0] == 'X' && matrix[0][1] == 'X' && matrix[0][2] == 'X') {
            return true;
        } else if (matrix[1][0] == 'X' && matrix[1][1] == 'X' && matrix[1][2] == 'X') {
            return true;
        } else if (matrix[2][0] == 'X' && matrix[2][1] == 'X' && matrix[2][2] == 'X') {
            return true;
        } else if (matrix[0][0] == 'X' && matrix[1][0] == 'X' && matrix[2][0] == 'X') {
            return true;
        } else if (matrix[0][1] == 'X' && matrix[1][1] == 'X' && matrix[2][1] == 'X') {
            return true;
        } else if (matrix[0][2] == 'X' && matrix[1][2] == 'X' && matrix[2][2] == 'X') {
            return true;
        } else if (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') {
            return true;
        } else if (matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOWin(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

            }
        }
        if (matrix[0][0] == 'O' && matrix[0][1] == 'O' && matrix[0][2] == 'O') {
            return true;
        } else if (matrix[1][0] == 'O' && matrix[1][1] == 'O' && matrix[1][2] == 'O') {
            return true;
        } else if (matrix[2][0] == 'O' && matrix[2][1] == 'O' && matrix[2][2] == 'O') {
            return true;
        } else if (matrix[0][0] == 'O' && matrix[1][0] == 'O' && matrix[2][0] == 'O') {
            return true;
        } else if (matrix[0][1] == 'O' && matrix[1][1] == 'O' && matrix[2][1] == 'O') {
            return true;
        } else if (matrix[0][2] == 'O' && matrix[1][2] == 'O' && matrix[2][2] == 'O') {
            return true;
        } else if (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') {
            return true;
        } else if (matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O') {
            return true;
        } else {
            return false;
        }
    }

    public static int countX(char[][] matrix) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countO(char[][] matrix) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 'O') {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isFinalGame(char[][] matrix) {
        if (isXWin(matrix) && isOWin(matrix)) {
            System.out.println("Impossible");
            return true;
        } else if (Math.abs(countX(matrix) - countO(matrix)) > 1) {
            System.out.println("Impossible");
            return true;
        } else if (isXWin(matrix)) {
            System.out.println("X wins");
            return true;
        } else if (isOWin(matrix)) {
            System.out.println("O wins");
            return true;
        } else if (countO(matrix) + countX(matrix) == 9) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    public static void showMatrix(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.print("---------");
        System.out.println();
    }
}

