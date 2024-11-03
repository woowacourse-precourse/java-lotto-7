package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ExceptionCode.INCORRECT_NUMBER_COUNTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
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

    @DisplayName("당첨 번호와 일치하는 로또 번호의 개수를 세서 등수를 리턴한다.")
    @Test
    void countMatchesPositive() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 21, 22);
        assertThat(lotto.countRank(new Lotto(winningNumbers), 15)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("인자 리스트의 사이즈와 로또 번호의 개수가 다르면 예외가 발생한다.")
    @Test
    void countMatchesLengthException() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 20);
        assertThatThrownBy(() -> lotto.countRank(new Lotto(winningNumbers), 15))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INCORRECT_NUMBER_COUNTS.message());
    }

}
