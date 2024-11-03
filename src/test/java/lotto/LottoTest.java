package lotto;

import lotto.constant.Ranking;
import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("중복이 없는 6개의 숫자를 입력하면 Lotto 객체를 생성한다.")
    void create() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @Test
    @DisplayName("번호 개수가 6개 이하일 경우 예외가 발생한다.")
    void throwSizeException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        // when, then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호에 1미만의 숫자가 존재할 경우 예외가 발생한다.")
    void throwMinRangeException() {
        // given
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);
        // when, then
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호에 45가 넘어가는 숫자가 존재할 경우 예외가 발생한다.")
    void throwMaxRangeException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        // when, then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호 문자열을 생성한다.")
    void getScreen() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        String screen = lotto.getScreen();
        // then
        assertThat(screen).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("입력받은 숫자가 로또에 존재할 경우 true를 반환한다.")
    void contains() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 1;
        // when
        boolean contains = lotto.contains(number);
        // then
        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("입력받은 숫자가 로또에 존재하지 않을 경우 false를 반환한다.")
    void notContains() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int number = 7;
        // when
        boolean contains = lotto.contains(number);
        // then
        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("입력받은 당첨번호와 Lotto의 숫자가 모두 일치할 경우 1위에 당첨된다.")
    void getFirst() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        // when
        Ranking ranking = lotto.getRanking(winningLotto);
        // then
        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    @DisplayName("입력받은 당첨번호와 Lotto의 숫자가 5개 일치하고, 보너스 숫자가 Lotto에 존재할 경우 2위에 당첨된다.")
    void getSecond() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 45)), new BonusNumber(6));
        // when
        Ranking ranking = lotto.getRanking(winningLotto);
        // then
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Test
    @DisplayName("입력받은 당첨번호와 Lotto의 숫자가 5개 일치하고, 보너스 숫자가 Lotto에 존재하지 않을 경우 3위에 당첨된다.")
    void getThird() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 45)), new BonusNumber(44));
        // when
        Ranking ranking = lotto.getRanking(winningLotto);
        // then
        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @Test
    @DisplayName("입력받은 당첨번호와 Lotto의 숫자가 4개 일치할 경우 4위에 당첨된다.")
    void getFourth() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 44, 45)), new BonusNumber(43));
        // when
        Ranking ranking = lotto.getRanking(winningLotto);
        // then
        assertThat(ranking).isEqualTo(Ranking.FOURTH);
    }

    @Test
    @DisplayName("입력받은 당첨번호와 Lotto의 숫자가 3개 일치할 경우 5위에 당첨된다.")
    void getFifth() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 43, 44, 45)), new BonusNumber(42));
        // when
        Ranking ranking = lotto.getRanking(winningLotto);
        // then
        assertThat(ranking).isEqualTo(Ranking.FIFTH);
    }

    @Test
    @DisplayName("입력받은 당첨번호와 Lotto의 숫자가 3개이하로 일치할 경우 당첨되지 않는다.")
    void getNone() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 42, 43, 44, 45)), new BonusNumber(41));
        // when
        Ranking ranking = lotto.getRanking(winningLotto);
        // then
        assertThat(ranking).isEqualTo(Ranking.NONE);
    }
}
