package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.create(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideWinningNumbersInWrongRange")
    void 범위에서_벗어난_당첨_번호가_있으면_예외가_발생한다(List<Integer> wrongNumbers) {
        assertThatThrownBy(() -> WinningNumbers.create(wrongNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideWinningNumbersInWrongRange() {
        return Stream.of(
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }
}
