package lotto.domain;

import lotto.constants.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constants.ErrorMessage.ERROR_LOTTO_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_LOTTO_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideRankingResult")
    void 당첨_정보와_비교해_당첨_순위_계산_한다(List<Integer> winningNumbers, int bonusNumber, Ranking expectedRanking) {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(winningNumbers), bonusNumber);
        Ranking ranking = lotto.checkRanking(winningLotto);

        assertThat(ranking).isEqualTo(expectedRanking);
    }

    @Test
    void 로또의_모든_번호를_조회하는_기능_테스트(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(numbers);

        List<Integer> numberValues = lotto.getNumberValues();

        assertThat(numberValues).isEqualTo(numbers);
    }

    static Stream<Arguments> provideRankingResult() {
        /**
         * 로또 번호 1,2,3,4,5,6 인 경우
         */
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, Ranking.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 45), 6, Ranking.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 44), 45, Ranking.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 43, 44), 45, Ranking.FOURTH),
                Arguments.of(List.of(1, 2, 3, 42, 43, 44), 45, Ranking.FIFTH),
                Arguments.of(List.of(1, 2, 41, 42, 43, 44), 45, Ranking.NONE)
        );
    }
}
