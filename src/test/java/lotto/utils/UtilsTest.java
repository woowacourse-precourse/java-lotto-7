package lotto.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @DisplayName("문자열이 숫자로 구성되었는지 확인한다")
    @Test
    void isDigitOnly() {
        assertTrue(Utils.isDigitOnly("123123"));
        assertTrue(Utils.isDigitOnly("1"));
        assertTrue(Utils.isDigitOnly("2147483647"));
    }

    @DisplayName("숫자가 min ~ max 범위에 들어 오는지 확인한다. [int 버전]")
    @Test
    void isInRange() {
        assertTrue(Utils.isInRange(1, 45, 1));
        assertTrue(Utils.isInRange(1, 45, 45));
        assertTrue(Utils.isInRange(1, 45, 10));
    }

    @DisplayName("숫자가 min ~ max 범위에 들어 오는지 확인한다. [BigDecimal 버전]")
    @Test
    void isInRangeBigDecimalType() {
        BigDecimal min = new BigDecimal(1);
        BigDecimal max = new BigDecimal(45);
        BigDecimal num = new BigDecimal(10);

        assertTrue(Utils.isInRange(min, max, num));
    }

    @DisplayName("문자열인 숫자를 BigDecimal 타입으로 변환하는 기능 테스트")
    @Test
    void stringToNumber() {
        BigDecimal origin = new BigDecimal(123);
        BigDecimal target = Utils.stringToNumber("123");

        assertEquals(origin, target);
    }

    @DisplayName("숫자가 1000 으로 나누어 떨어지는지 확인한다")
    @Test
    void isDivisibleByThousand() {
        assertTrue(Utils.isDivisibleByThousand(1000));
        assertTrue(Utils.isDivisibleByThousand(10000));
        assertTrue(Utils.isDivisibleByThousand(5000));
    }

    @DisplayName("문자열 배열이 모두 숫자인지 확인한다.")
    @Test
    void allElementsAreDigits() {
        String[] input = {"1", "100", "3"};

        assertTrue(Utils.allElementsAreDigits(input));
    }

    @DisplayName("문자열 배열의 크기가 x개 인지 확인한다.")
    @Test
    void checkSizeEqual() {
        String[] input = {"1", "2", "3", "4", "5", "6"};

        assertTrue(Utils.checkSizeEqual(input, 6));
    }

}