package lotto.domain;

import lotto.model.domain.Money;
import lotto.util.parser.InputParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 입력금액이_비어있을때_예외발생(String input) {
        assertThatThrownBy(() -> new Money(InputParser.parseNumber(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {11000, 20000, 8000})
    void 입력금액이_1000원_단위일때_통과하는지_확인(int validAmount) {
        assertDoesNotThrow(() -> new Money(validAmount));
    }

    @Test
    void 입력금액이_1000원_단위가_아닐때_예외발생() {
        int inValidAmount = 2500;

        assertThatThrownBy(() -> new Money(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 999})
    void 입력금액이_1000원_미만_혹은_음수일때_예외발생(int inValidAmount) {
        assertThatThrownBy(() -> new Money(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력금액이_최대값_초과시_예외발생() {
        int inValidAmount = 10000000;

        assertThatThrownBy(() -> new Money(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
