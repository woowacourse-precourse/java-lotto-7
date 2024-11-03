package lotto.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseAmountValidatorTest {
    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @DisplayName("구입금액이 1,000 미만 또는 100,000 초과일 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"900", "100001"})
    void 구입금액_범위_검증_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.checkValueRange(input));
    }

    @DisplayName("구입금액을 1000으로 나눌 수 없으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000.1", "1100"})
    void 천_단위_검증_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.checkDivisibility(input));
    }
}
