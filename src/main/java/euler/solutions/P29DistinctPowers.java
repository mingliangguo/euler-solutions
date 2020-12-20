package euler.solutions;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=29
 *
 * Distinct powers
 * Consider all integer combinations of a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
 *
 * 2^2=4, 2^3=8, 2^4=16, 2^5=32
 * 3^2=9, 3^3=27, 3^4=81, 3^5=243
 * 4^2=16, 4^3=64, 4^4=256, 4^5=1024
 * 5^2=25, 5^3=125, 5^4=625, 5^5=3125
 * If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:
 *
 * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
 *
 * How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
 */
public class P29DistinctPowers {
  /**
   * Calculate the total distinct combination generated by a^b, where 2 <=a, b <= n
   *
   * The algorithm is basically going through each pair of a^b and use a HashSet to get the distinct result.
   *
   * Use {@link java.math.BigInteger} to handle calculation of large numbers.
   *
   * @param n the upper bound for the calculation
   *
   * @return the total number
   */
  public Set<BigInteger> distinctPowers(int n) {
    assert n > 0 : "n must be greater than 0, while n is:" + n;;

    Set<BigInteger> set = new HashSet<>();
    for (int a = 2; a <= n; a++) {
      for (int b = 2; b <= n; b++) {
        // calculate each pair of a^b
        set.add(BigInteger.valueOf(a).pow(b));
      }
    }
    return set;
  }

  public static void main(String[] args) {
    P29DistinctPowers dp = new P29DistinctPowers();
    int n = 100;
    Instant start = Instant.now();
    int count = dp.distinctPowers(n).size();
    System.out.println("Total count: " + count);
    System.out.println("Total time: " + Duration.between(start, Instant.now()).toMillis() + "ms");
  }
}
