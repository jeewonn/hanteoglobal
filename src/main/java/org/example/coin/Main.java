package org.example.coin;

public class Main {
    public static void main(String[] args) {
        int sum = 10;
        int[] coins = new int[]{2, 5, 3, 6};
        System.out.println(CoinCombination.countCoinCombination(sum, coins));  // 출력: 5
    }
}
