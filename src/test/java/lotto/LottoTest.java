package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("6개 전부 일치")
    @Test
    void testSixMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int result = lotto.countMatchingWinningNumbers(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("5개 일치 + 보너스 번호 일치")
    @Test
    void testFiveMatchesWithBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;

        int result = lotto.countMatchingWinningNumbers(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("5개 일치, 보너스 번호는 일치하지 않음")
    @Test
    void testFiveMatchesWithoutBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 9);
        int bonusNumber = 6;

        int result = lotto.countMatchingWinningNumbers(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("4개 일치")
    @Test
    void testFourMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 7, 8);
        int bonusNumber = 6;

        int result = lotto.countMatchingWinningNumbers(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("일치 없음")
    @Test
    void testNoMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        int bonusNumber = 13;

        int result = lotto.countMatchingWinningNumbers(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(0);
    }

}
