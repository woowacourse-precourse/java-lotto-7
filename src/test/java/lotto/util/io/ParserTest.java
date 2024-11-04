package lotto.util.io;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    private static final String ERROR_PREFIX = "[ERROR]";

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "1.1", "100k"})
    void 구매_금액이_정수가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.parseInputToMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_PREFIX);
    }
}
