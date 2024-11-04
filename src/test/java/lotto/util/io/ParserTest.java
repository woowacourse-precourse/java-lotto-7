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

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "1.0,2,3", "1, 2, 3", "1f,2f,3f"})
    void 당첨_번호가_숫자와_구분자_외_문자가_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.parseInputToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_PREFIX);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "1.0", "1k"})
    void 보너스_번호가_숫자_외_문자가_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Parser.parseInputToNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_PREFIX);
    }
}
