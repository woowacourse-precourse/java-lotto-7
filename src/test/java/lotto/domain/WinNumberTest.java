package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinNumberTest {
    @Test
    void 보너스_번호가_당첨_번호에_존재하면_예외가_발생한다() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.from("3");
        assertThatThrownBy(() -> WinNumber.of(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateLottoData")
    void 당첨_번호를_바탕으로_몇_개가_맞았는지_잘_출력한다(Lotto lotto, int expectedMatchCount) {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumber = BonusNumber.from("8");
        WinNumber winNumber = WinNumber.of(winningNumber, bonusNumber);

        int matchCount = winNumber.matchWithLotto(lotto);
        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 5),
                Arguments.of(new Lotto(List.of(3, 4, 5, 6, 7, 8)), 4),
                Arguments.of(new Lotto(List.of(4, 5, 6, 7, 8, 9)), 3),
                Arguments.of(new Lotto(List.of(10, 11, 12, 13, 14, 15)), 0)
        );
    }
}
