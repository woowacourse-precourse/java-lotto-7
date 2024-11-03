package lotto.util;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitNumbersTest {
    @Test
    void 구분자_오류() {
        assertThrows(IllegalArgumentException.class, () -> SplitNumbers.splitWinningNumbers("1,2,3,4,5;6"));
    }
    @Test
    void 정상적으로_당첨번호_분리() {
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);
        assertEquals(expected, SplitNumbers.splitWinningNumbers("1,2,3,4,5,6"));
    }
    @Test
    void 공백포함_당첨번호_분리() {
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);
        assertEquals(expected, SplitNumbers.splitWinningNumbers("1,2 ,3,4, 5,6"));
    }
}