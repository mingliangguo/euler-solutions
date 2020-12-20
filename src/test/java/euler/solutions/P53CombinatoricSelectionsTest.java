package euler.solutions;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P53CombinatoricSelectionsTest {
    @Test
    void testCalcCombinations() {
        P53CombinatoricSelections cs = new P53CombinatoricSelections();

        Assertions.assertEquals(cs.calcCombinations(5, 3), BigInteger.valueOf(10), "C(5, 3) should be 10.");

        // test the boundary
        Assertions.assertEquals(cs.calcCombinations(5, 0), BigInteger.valueOf(1), "C(5, 0) should be 1.");

        Assertions.assertEquals(cs.calcCombinations(23, 10), BigInteger.valueOf(1144066), "C(23, 10) should be 1144066.");
    }

    @Test
    void testCountCombinationsUsingDefaultConstructor() {
        P53CombinatoricSelections cs = new P53CombinatoricSelections();
        Assertions.assertEquals(cs.countCombination(100), 4075, "Total count of C(n, r) for n <=100 should be 4075.");
    }

    @Test
    void testCountCombinationsUsingCustomLowerBound() {
        P53CombinatoricSelections cs = new P53CombinatoricSelections(BigInteger.valueOf(50));
        Assertions.assertEquals(cs.countCombination(10), 12, "Total number of combinations greater than 50 is 12");
    }

    @Test
    void testCountCombinationsUsingNullLowerBound() {
        P53CombinatoricSelections cs = new P53CombinatoricSelections(null);
        Assertions.assertEquals(cs.countCombination(100), 4075,
                "null lower bound should fall to the default 1 million and has the same result as default constructor");
    }

    @Test
    void testInvalidInput() {
        P53CombinatoricSelections cs = new P53CombinatoricSelections();
        Assertions.assertThrows(AssertionError.class, () -> cs.countCombination(-10), "-10 is not a valid input.");

        Assertions.assertThrows(AssertionError.class, () -> cs.calcCombinations(-10, 0), "(-10, 0) is not a valid input.");
        Assertions.assertThrows(AssertionError.class, () -> cs.calcCombinations(10, -1), "(10, -1) is not a valid input.");
    }
}
