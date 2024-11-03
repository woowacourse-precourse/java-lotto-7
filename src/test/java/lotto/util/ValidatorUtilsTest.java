package lotto.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void 빈_값이_입력되었다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    ValidatorUtils.isNotEmpty(input);
                }).withMessageContaining("빈 값은 입력하실 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"^&", "1j"})
    void 숫자로_변환되지_않는다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    ValidatorUtils.canParseToInt(input);
                }).withMessageContaining("숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 0})
    void 숫자로_변환되지_않는다면_예외가_발생한다(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    ValidatorUtils.isInRange(input);
                }).withMessageContaining("1 ~ 45 사이의 수를 입력하셔야 합니다.");
    }
}
