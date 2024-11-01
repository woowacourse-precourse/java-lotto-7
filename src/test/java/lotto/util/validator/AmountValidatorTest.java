package lotto.util.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountValidatorTest {


    @ParameterizedTest
    @ValueSource(ints = {1000})
    void 입력금액이_1000원_단위일때_통과한다(int validAmount) {
        AmountValidator.validateAmount(validAmount);
    }

    @Test
    void 입력금액이_1000원_단위가_아닐때_예외발생() {
        int inValidAmount = 2500;
        // Check only that an exception is thrown
        assertThatThrownBy(() -> AmountValidator.validateAmount(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 999})
    void 입력금액이_1000원_미만_혹은_음수일때_예외발생(int inValidAmount) {
        assertThatThrownBy(() -> AmountValidator.validateAmount(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력금액이_최대값_초과시_예외발생() {
        int inValidAmount = 10000000;
        assertThatThrownBy(() -> AmountValidator.validateAmount(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
