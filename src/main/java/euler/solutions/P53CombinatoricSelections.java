package euler.solutions;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

/**
 * https://projecteuler.net/problem=53
 * Combinatoric selections
 *
 * <b>Note: </b> Use this class wisely to handle large input. It's likely not efficient enough to produce the result quick enough.
 * If you are looking for handling large input, an alternative approach with more efficient algorithms should be pursued.
 */
public class P53CombinatoricSelections {
  /**
   *  Lower bound value used to determine if a result should be counted.
   */
  private BigInteger LOWER_BOUND;
  private static final BigInteger MILLION = BigInteger.TEN.pow(6);

  /**
   * Default constructor which uses 1 million as the lower bound to count
   */
  public P53CombinatoricSelections() {
    this(MILLION);
  }

  /**
   * Constructor which allows an optional lower bound to be passed in
   *
   * <b>Note: </b> the lower bound should be set large enough based on the range of the input.
   *
   * @param lower
   */
  public P53CombinatoricSelections(BigInteger lower) {
    this.LOWER_BOUND = Optional.ofNullable(lower)
            .orElse(MILLION);
  }

  /**
   * Calculate the number of combinations of C(n, r),  whose sum is greater than the lower bound
   * @param n the upper bound of the n to choose values from
   *
   * @return  the number of combinations whose count is greater than the lower bound
   */
  public long countCombination(int n) {
    assert n > 0 : "n must be greater than 0, while n is:" + n;;

    long count = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= i; j++) {
        BigInteger res = calcCombinations(i, j);
        if (res.compareTo(LOWER_BOUND) > 0) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Calculate the number of combinations of picking r from n.
   * The formula: C(n, r) = P(n, r) / r!
   * @param n
   * @param r
   * @return the number of total combinations of C(n, r)
   */
  public BigInteger calcCombinations(int n, int r) {
    assert n > 0 && r >= 0 : "n must be greater than 0 and r must be greater or equal to 0, while n is:" + n + ", r is:" + r;

    BigInteger res = BigInteger.ONE;
    // P(n, r) = n! / (n - r)! = n * (n - 1) * (n - 2) * .... * (n - r + 1)
    for (int i = n; i > (n - r); i--) {
      res = res.multiply(BigInteger.valueOf(i));
    }
    // P(n, r) / r!
    for (int j = r; j > 1; j--) {
      res = res.divide(BigInteger.valueOf(j));
    }
    return res;
  }

  public static void main(String[] args) {
    P53CombinatoricSelections cs = new P53CombinatoricSelections();
    Instant start = Instant.now();
    long count = cs.countCombination(100);

    System.out.println("Total count is: " + count);
    System.out.println("Total time is: " + Duration.between(start, Instant.now()).toMillis() + "ms");
  }
}
