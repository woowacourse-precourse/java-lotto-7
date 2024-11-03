package lotto.domain;

import lotto.model.condition.SpendingMoney;
import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpendingMoneyTest {

    @Test
    @DisplayName("예외 메시지 : 입력 없음")
    void exceptionMessageTestEmptyInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new SpendingMoney(""));
        assertEquals(ExceptionMessage.EMPTY_INPUT.toString(),
                exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : 공백 입력")
    void exceptionMessageTestContainsBlankInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new SpendingMoney(" 10000"));
        assertEquals(ExceptionMessage.BLANK_INPUT.toString(),
                exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "2000@"})
    @DisplayName("예외 메시지 : 숫자 아닌 문자 입력")
    void exceptionMessageTestContainsNotDigitInput(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new SpendingMoney(input));
        assertEquals(ExceptionMessage.NO_DIGIT_INPUT.toString(),
                exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : long 범위보다 큰 숫자")
    void exceptionMessageTestOutRangeLongInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new SpendingMoney("1000000000000000000000000000000"));
        assertEquals(Constants.EXCEPTION_MESSAGE_PREFIX +
                        "2의 63 제곱보다 작은 값을 입력하세요.",
                exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : 티켓 가격 미만")
    void exceptionMessageTestUnderTicketPriceInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new SpendingMoney("999"));
        assertEquals("[ERROR] 구매 금액은 " + Constants.LOTTO_TICKET_PRICE +
                "보다 커야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("예외 메시지 : 잔돈 발생")
    void exception_message_test_small_change_input() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new SpendingMoney("1999"));
        assertEquals("[ERROR] 구매 금액은 " + Constants.LOTTO_TICKET_PRICE +
                "원으로 나누어 떨어져야 합니다.", exception.getMessage());
    }

}
