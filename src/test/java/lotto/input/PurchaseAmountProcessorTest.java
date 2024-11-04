package lotto.input;

import static lotto.constant.LottoConstants.MAX_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.*;
import static lotto.input.PurchaseAmountProcessor.calculatePurchaseCount;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


public class PurchaseAmountProcessorTest {

    @DisplayName("빈 문자열 또는 공백인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testEmptyOrBlankInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatePurchaseCount(input))
                .withMessage(EMPTY_INPUT.getMessage());
    }

    @DisplayName("문자열인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"천 원", "문자열", "돈입니다"})
    void testStringInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatePurchaseCount(input))
                .withMessage(NON_NUMERIC_INPUT.getMessage());
    }

    @DisplayName("음수, 0, 실수인 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"-2000", "0", "1000.0", "   -  3000", "    0   ", "   5.  4"})
    void testInvalidIntInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatePurchaseCount(input))
                .withMessage(ONLY_POSITIVE_INPUT.getMessage());
    }

    @DisplayName("양의 부호를 포함한 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {" + 2000",  "+900"})
    void testInvalidSignInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatePurchaseCount(input))
                .withMessage(POSITIVE_SIGN_INPUT.getMessage());
    }

    @DisplayName("1,000,000,000을 초과한 경우 - IllegalArgumentException 반환")
    @Test
    void testMaxAmount() {
        // given
        String input = "1000000001";

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatePurchaseCount(input))
                .withMessage(EXCEEDS_MAX_AMOUNT.getMessageWithMaxAmount(MAX_PURCHASE_AMOUNT));
    }

    @DisplayName("1,000원 단위로 나누어 떨어지지 않는 경우 - IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(strings = {"100", "10001", "1111", "1010"})
    void testInvalidUnitInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatePurchaseCount(input))
                .withMessage(INVALID_AMOUNT_UNIT.getMessage());
    }

    @DisplayName("유효한 입력 - 발행할 로또 수량 반환")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "10000, 10", "12000, 12", "   3000, 3"})
    void testValidInput(String input, int expected) {
        // given & when
        int result = calculatePurchaseCount(input);

        // then
        assertEquals(expected, result);
    }


}
