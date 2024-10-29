package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinnerNumberValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void 빈_값이_입력되었다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    WinnerNumberValidator.isNotEmpty(input);
                }).withMessageContaining("빈 값은 입력하실 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"^&", "1j"})
    void 숫자로_변환되지_않는다면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    WinnerNumberValidator.canParseToInt(input);
                }).withMessageContaining("숫자를 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 일과_사십오_사이의_수가_아니라면_예외가_발생한다(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    WinnerNumberValidator.isInRange(input);
                }).withMessageContaining("1 ~ 45 사이의 수를 입력하셔야 합니다.");
    }

    @Test
    void 여섯개의_서로_다른_수가_아니라면_예외가_발생한다_중복() {
        TreeSet<Integer> duplicatedNumbers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 5));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    WinnerNumberValidator.isSixDifferentNumbers(duplicatedNumbers);
                })
                .withMessageContaining("6개의 서로 다른 수를 입력하셔야 합니다.");
    }

    @Test
    void 여섯개의_서로_다른_수가_아니라면_예외가_발생한다_초과() {
        TreeSet<Integer> overLengthNumbers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6, 7));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    WinnerNumberValidator.isSixDifferentNumbers(overLengthNumbers);
                })
                .withMessageContaining("6개의 서로 다른 수를 입력하셔야 합니다.");
    }
}
