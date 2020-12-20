package euler.solutions;

import java.time.Duration;
import java.time.Instant;

/**
 * https://projecteuler.net/problem=31
 * Distinct powers
 *
 * In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
 * It is possible to make £2 in the following way:
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class P31CoinSum {
  /**
   * Calculate the total ways of changing the amount using the provided type of coins
   *
   * Note: This is a typical dynamic programming problem.
   *
   * dp[j] is used to represent the number of ways to change `j` using the given coins
   * And dp[j] = dp[j] + dp[j - coin[i]]
   *
   * @param coins number of different coins to use.
   * @param amount amount of money to change
   * @return number of ways to change the money
   */
  public int coinSum(int[] coins, int amount) {
    assert coins != null && coins.length != 0 : "coins cannot be null or zero-length, while coins is:" + coins;
    assert amount > 0 : "amount must be greater than 0, while amount is:" + amount;;;

    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int j = coin; j <= amount; j++) {
        dp[j] += dp[j - coin];
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    P31CoinSum cs = new P31CoinSum();

    int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    int amount = 200;
    Instant start = Instant.now();
    int res = cs.coinSum(coins, amount);

    System.out.println("Total ways is: " + res);
    System.out.println("Total time is: " + Duration.between(start, Instant.now()).toMillis() + "ms");
  }
}
