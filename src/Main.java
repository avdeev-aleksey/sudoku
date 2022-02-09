import java.util.*;

public class Main {


    private static final int element = 9;
    private static int square;// сторона одного маленького квадрата равна квадртному корню из
                              // element, если корень не извлекается в целых числах, то все
                              // судоку состоит их одного квадрата, например 11x11 будет
                              //  представлять собой один квадрат с числами от 1 до 121

    public static void main(String[] args) {


        square = (int) Math.sqrt(element);

        if (!(square * square == element))
            square = element;

//        int[][] sudoku = new int[element][element];


// массив для теста

        int[][] sudoku = {
                {1,3,4,2,5,7,6,8,9},
                {5,6,8,1,4,9,2,7,3},
                {7,9,2,3,6,8,1,5,4},
                {2,1,3,4,7,5,8,9,6},
                {4,5,9,8,3,6,7,1,2},
                {6,8,7,9,1,2,4,3,5},
                {3,2,1,5,8,4,9,6,7},
                {9,7,5,6,2,1,3,4,8},
                {8,4,6,7,9,3,5,2,1}
        };




        if (checkSudoku(sudoku))
            System.out.println("корректно");
        else
            System.out.println("некорректно");


    }


    private static boolean checkSudoku(int[][] sudoku) {
        if (checkHorizontal(sudoku) && checkVertical(sudoku)) {
            for (int i = 0; i < element; i = i + square) {
                for (int j = 0; j < element; j = j + square) {
                    if (!checkSquare(sudoku, i, j))
                        return false;
                }
            }
            return true;
        } else
            return false;
    }


    private static boolean checkHorizontal(int[][] sudoku) {
        for (int i = 0; i < element; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < element; j++) {
                if (sudoku[i][j] > square * square || sudoku[i][j] < 1)
                    return false;
                hashSet.add(sudoku[i][j]);
            }
            if (hashSet.size() != element)
                return false;

        }
        return true;
    }


    private static boolean checkVertical(int[][] sudoku) {
        for (int i = 0; i < element; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < element; j++) {
                if (sudoku[j][i] > square * square || sudoku[j][i] < 1)
                    return false;
                hashSet.add(sudoku[j][i]);
            }
            if (hashSet.size() != element)
                return false;
        }
        return true;
    }


    private static boolean checkSquare(int[][] sudoku, int i, int j) {
        Set<Integer> hashSet = new HashSet<>();
        for (int a = 0; a < square; a++) {
            for (int b = 0; b < square; b++) {
                hashSet.add(sudoku[i + a][j + b]);
            }
        }
        if (hashSet.size() == square * square)
            return true;
        else
            return false;
    }
}
