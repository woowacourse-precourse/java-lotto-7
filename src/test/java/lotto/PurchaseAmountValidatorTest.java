package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.validators.PurchaseAmountValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseAmountValidatorTest {
    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @DisplayName("구입금액이 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"asdf", "100", "1000.1", "200000"})
    void 구입금액_입력값_검증_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }
}
