package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
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

    @Test
    @DisplayName("로또 번호는 6개의 숫자여야 한다.")
    void lottoNumbersShouldBeSix() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호는 중복될 수 없다.")
    void lottoNumbersShouldNotBeDuplicated() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("로또 번호는 1부터 45 사이의 숫자여야 한다.")
    void lottoNumbersShouldBeBetween1And45() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 생성 시 번호가 유효하면 예외가 발생하지 않는다.")
    void validLottoNumbersDoesNotThrowException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 등수를 반환한다.")
    void match_returnsCorrectRank() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 7, 8, 9), 4);

        Rank rank = lotto.match(winningLotto);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("보너스 번호 일치 시 등수를 올바르게 반환한다.")
    void match_bonusNumberMatch_returnsCorrectRank() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Rank rank = lotto.match(winningLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
