package lotto.model;

import lotto.Message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoAmountTest {

    @Test
    @DisplayName("유효한 금액 입력으로 로또 개수를 올바르게 계산한다")
    void testGetAmount_ValidInput() {
        // Given
        String input = "5000";

        // When
        LottoAmount lottoAmount = new LottoAmount(input);
        int amount = lottoAmount.getAmount();

        // Then
        assertEquals(5, amount);
    }

    @Test
    @DisplayName("0원 이하의 금액 입력 시 예외가 발생한다")
    void testConstructor_InvalidZeroOrNegativeInput() {
        // Given
        String input = "0";

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoAmount(input);
        });
        assertEquals(ErrorMessage.ERROR_NOT_THOUSAND_UNIT.toString(), exception.getMessage());
    }

    @Test
    @DisplayName("천 원 단위가 아닌 금액 입력 시 예외가 발생한다")
    void testConstructor_InvalidNonThousandUnitInput() {
        // Given
        String input = "1500";

        // When - hen
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoAmount(input);
        });
        assertEquals(ErrorMessage.ERROR_NOT_THOUSAND_UNIT.toString(), exception.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 입력으로 예외가 발생한다")
    void testConstructor_InvalidNonNumberInput() {
        // Given
        String input = "abc";

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoAmount(input);
        });
        assertEquals(ErrorMessage.ERROR_INVALID_NUMBER.toString(), exception.getMessage());
    }
}
