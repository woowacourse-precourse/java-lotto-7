package lotto.model.domain;

import lotto.MoneyInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    private static final long VALID_AMOUNT = 5000;
    private static final long INVALID_AMOUNT_NON_MULTIPLE = 5500;
    private static final long INVALID_AMOUNT_ZERO = 0;
    private static final long INVALID_AMOUNT_NEGATIVE = -1000;

    @Test
    @DisplayName("유효한 금액이 주어지면 Money 객체가 성공적으로 생성된다")
    void givenValidAmount_whenCreatingMoney_thenObjectIsCreated() {
        // given
        long amount = VALID_AMOUNT;

        // when
        Money money = new Money(amount);

        // then
        assertNotNull(money);
        assertEquals(amount, money.getAmount());
    }

    @Test
    @DisplayName("금액이 0 이하일 경우 예외가 발생한다")
    void givenZeroOrNegativeAmount_whenCreatingMoney_thenThrowsException() {
        // given, when & then
        IllegalArgumentException exceptionZero = assertThrows(IllegalArgumentException.class, () -> new Money(INVALID_AMOUNT_ZERO));
        assertEquals(MoneyInputErrorMessage.INVALID_NUMBER_FORMAT.getMessage(), exceptionZero.getMessage());

        IllegalArgumentException exceptionNegative = assertThrows(IllegalArgumentException.class, () -> new Money(INVALID_AMOUNT_NEGATIVE));
        assertEquals(MoneyInputErrorMessage.INVALID_NUMBER_FORMAT.getMessage(), exceptionNegative.getMessage());
    }

    @Test
    @DisplayName("금액이 1000의 배수가 아니면 예외가 발생한다")
    void givenNonMultipleOfThousandAmount_whenCreatingMoney_thenThrowsException() {
        // given
        long amount = INVALID_AMOUNT_NON_MULTIPLE;

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Money(amount));
        assertEquals(MoneyInputErrorMessage.NON_THOUSAND_MULTIPLE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("getAmount 메서드는 올바른 금액을 반환한다")
    void whenCallingGetAmount_thenReturnsCorrectAmount() {
        // given
        Money money = new Money(VALID_AMOUNT);

        // when
        long result = money.getAmount();

        // then
        assertEquals(VALID_AMOUNT, result);
    }
}