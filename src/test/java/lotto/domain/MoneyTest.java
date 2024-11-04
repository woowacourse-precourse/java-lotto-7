package lotto.domain;

import lotto.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    @Test
    @DisplayName("정상적인 금액 입력으로 Money 객체가 생성되는지 확인")
    void testValidMoneyCreation() {
        Money money = new Money("5000");
        assertEquals(5000, money.getAmount());
    }

    @Test
    @DisplayName("숫자가 아닌 금액 입력에 대해 예외 발생 테스트")
    void testNonNumericMoneyThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Money("abc")
        );
        assertEquals(ErrorCode.INPUT_POSITIVE_INTEGER.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않는 금액 입력에 대해 예외 발생 테스트")
    void testNonDivisibleByThousandThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Money("5500")
        );
        assertEquals(ErrorCode.PRICE_DIVIDABLE_BY_UNIT.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("0 이상의 숫자인 금액 입력에 대해 정상적으로 Money 객체가 생성되는지 확인")
    void testNonNegativeMoneyCreation() {
        Money money = new Money("0");
        assertEquals(0, money.getAmount());
    }
}
