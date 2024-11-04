package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigDecimalUtilTest {

    @Test
    @DisplayName("총 상금을 총 사용 금액으로 나누고 백분율로 변환하는 메서드 테스트")
    void testDivideAndMultiplyByPercentage() {
        // given
        BigDecimal totalPrize = BigDecimal.valueOf(5000);
        BigDecimal totalSpent = BigDecimal.valueOf(2000);

        // when
        BigDecimal result = BigDecimalUtil.divideAndMultiplyByPercentage(totalPrize, totalSpent);

        // then
        BigDecimal expected = BigDecimal.valueOf(250.0);
        assertEquals(0, result.compareTo(expected));
    }

    @Test
    @DisplayName("소수점 자릿수까지 반올림하는 메서드 테스트")
    void testRoundToDecimalPlaces() {
        // given
        BigDecimal value = BigDecimal.valueOf(123.45678);
        int scale = 2;

        // when
        double result = BigDecimalUtil.roundToDecimalPlaces(value, scale);

        // then
        assertEquals(123.46, result); // 기대 결과: 123.46
    }
}