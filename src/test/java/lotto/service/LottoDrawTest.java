package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoDrawTest {

    static Stream<Arguments> winningNumberFactory() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 45), 5),
                Arguments.arguments(List.of(1, 2, 3, 4, 44, 45), 4),
                Arguments.arguments(List.of(1, 2, 3, 43, 44, 45), 3),
                Arguments.arguments(List.of(1, 2, 42, 43, 44, 45), 2),
                Arguments.arguments(List.of(1, 41, 42, 43, 44, 45), 1),
                Arguments.arguments(List.of(40, 41, 42, 43, 44, 45), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("winningNumberFactory")
    public void 로또번호_당첨번호_비교_테스트(List<Integer> numbers, int expected) throws Exception {
        //Given
        WinningNumber winningNumbers = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        //When
        int actual = new LottoDraw().compareWinningNumber(lotto, winningNumbers);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> bonusNumberFactory() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), false),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 45), true)
        );
    }

    @ParameterizedTest
    @MethodSource("bonusNumberFactory")
    public void 로또번호_보너스번호_비교_테스트(List<Integer> numbers, boolean expected) throws Exception {
        //Given
        WinningNumber winningNumbers = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(45, winningNumbers);
        Lotto lotto = new Lotto(numbers);

        //When
        boolean actual = new LottoDraw().compareBonusNumber(lotto, bonusNumber);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}