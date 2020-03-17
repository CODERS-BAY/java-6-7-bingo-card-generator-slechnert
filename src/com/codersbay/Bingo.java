package com.codersbay;

import java.util.Random;

public class Bingo {
    public static void main(String[] args) {

        int[][] bingo = generateBingo();
        showBingo(bingo);

    }

    private static int[][] generateBingo() {
        int[][] bingo = new int[5][5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                int tmp = random.nextInt(16);
                while (tmp == 0) {
                    tmp = random.nextInt(16);
                }

                tmp += i * 15;

                while (tmp == bingo[0][i] ||    //check doublets
                        tmp == bingo[1][i] ||
                        tmp == bingo[2][i] ||
                        tmp == bingo[3][i]) {
                    tmp = random.nextInt(16);
                    tmp += i * 15;
                }
                bingo[j][i] = tmp;
            }
        }
        return bingo;
    }

    private static void showBingo(int[][] bingo) {
        //OUTPUT
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (x == 2 && y == 2) {
                    System.out.printf(" %2s ", "FS");
                } else {
                    System.out.printf(" %2d ", bingo[y][x]);
                }
            }
            System.out.println();
        }
    }
}