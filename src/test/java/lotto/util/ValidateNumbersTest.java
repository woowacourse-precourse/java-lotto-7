package lotto.util;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ValidateNumbersTest {
    @Test
    void 보너스번호_최대_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> new ValidateNumbers(46, winningNumbers));
    }
    @Test
    void 보너스번호_최소_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> new ValidateNumbers(0, winningNumbers));
    }
    @Test
    void 보너스번호_중복_테스트() {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> new ValidateNumbers(5, winningNumbers));
    }
    @Test
    void 당첨번호_길이_테스트() {
        List<Integer> numLengthOver = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThrows(IllegalArgumentException.class, () -> new ValidateNumbers(numLengthOver));
    }
    @Test
    void 당첨번호_최대_테스트() {
        List<Integer> overNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 46));
        assertThrows(IllegalArgumentException.class, () -> new ValidateNumbers(overNums));
    }
    @Test
    void 당첨번호_최소_테스트() {
        List<Integer> underNums = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        assertThrows(IllegalArgumentException.class, () -> new ValidateNumbers(underNums));
    }
    @Test
    void 당첨번호_중복_테스트() {
        List<Integer> duplicateNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 6));
        assertThrows(IllegalArgumentException.class, () -> new ValidateNumbers(duplicateNums));
    }
}