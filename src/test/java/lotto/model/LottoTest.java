package lotto.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2등 로또는 당첨 번호와 일치하는 로또 번호가 5개이면서 보너스 번호를 포함한다.")
    void testIfLottoRankSecond() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertTrue(lotto.isSecondRank(winningNumbers, bonusNum));
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 일치하는 로또 번호의 개수를 센다.")
    @MethodSource("provideWinningNumbersAndExpected")
    void countSameNumberTest(List<Integer> winningNumbers, Integer expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(lotto.countSameNumber(winningNumbers), expected);
    }

    private static Stream<Arguments> provideWinningNumbersAndExpected() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(List.of(1, 2, 3, 4, 7 ,8), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }
}
