package domain;

import lotto.domain.Lotto;
import lotto.domain.Rank;
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void 로또_번호_5개만_일치하는_경우() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 8;

        assertThat(lotto.getRank(winningNumber, bonus)).isEqualTo(Rank.THIRD_PLACE);
    }

    @Test
    void 로또_번호와_5개와_보너스_번호가_일치하는_경우() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 6;

        assertThat(lotto.getRank(winningNumber, bonus)).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    void 로또_번호가_0개_일치하는_경우() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber = List.of(7, 8, 9, 10, 11, 12);
        int bonus = 13;

        assertThat(lotto.getRank(winningNumber, bonus)).isEqualTo(Rank.NOTHING);
    }
}
