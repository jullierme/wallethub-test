package com.barros.jullierme.wallethubtest;

import java.util.Arrays;

public class CoinChange {

    public static int getSmallestCoinsCombination(int[] coins, int amount) {
        Arrays.sort(coins);// necessary to use break at the second loop

        int[] table = new int[amount + 1];

        Arrays.fill(table, amount + 1);

        table[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    table[i] = Math.min(table[i], 1 + table[i - coin]);
                } else {
                    break; // performance improvements
                }
            }
        }

        return table[amount] > amount ? -1 : table[amount];
    }

    public static void main(String[] args) {
        System.out.println(getSmallestCoinsCombination(new int[]{1, 2, 3, 4, 5}, 9));
        System.out.println(getSmallestCoinsCombination(new int[]{30, 25, 10, 5}, 30));
        System.out.println(getSmallestCoinsCombination(new int[]{25, 10, 5}, 30));
        System.out.println(getSmallestCoinsCombination(new int[]{9, 6, 5, 1}, 11));
        System.out.println(getSmallestCoinsCombination(new int[]{2, 10, 1, 50, 5}, 27));
        System.out.println(getSmallestCoinsCombination(new int[]{9, 6, 5, 1}, 11));
        System.out.println(getSmallestCoinsCombination(new int[]{2}, 3));
    }
}
