package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberTest {

    @ParameterizedTest
    @MethodSource("bonusWithWinningNumbers")
    void 보너스_번호는_당첨_번호와_다른_숫자로_생성된다(int number, WinningNumbers winningNumbers) {
        //when & then
        Assertions.assertThatCode(() -> BonusNumber.create(number, winningNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("wrongBonusWithWinningNumbers")
    void 보너스_번호가_당첨_번호와_중복되거나_범위에서_벗어나면_예외가_발생한다(int wrongNumber, WinningNumbers winningNumbers) {
        //when & then
        Assertions.assertThatThrownBy(() -> BonusNumber.create(wrongNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> bonusWithWinningNumbers() {
        return Stream.of(
                Arguments.of(7, WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6)))
        );
    }

    private static Stream<Arguments> wrongBonusWithWinningNumbers() {
        return Stream.of(
                Arguments.of(0, WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6))),
                Arguments.of(46, WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6))),
                Arguments.of(6, WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6)))
        );
    }
}
