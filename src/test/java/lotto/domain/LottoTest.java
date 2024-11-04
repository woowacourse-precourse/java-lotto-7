package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.util.enums.Rank;
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

    @DisplayName("로또 등수 반환_1등")
    @Test
    void 번호가_6개_일치하면_1등_반환() {
        Lotto lotto = new Lotto((List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Rank rank = lotto.calculateRank(winningNumbers, 7);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("로또 등수 반환_2등")
    @Test
    void 보너스_번호와_번호가_5개_일치하면_2등_반환() {
        Lotto lotto = new Lotto((List.of(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Rank rank = lotto.calculateRank(winningNumbers, 7);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또 등수 반환_3등")
    @Test
    void 번호가_5개_일치하면_3등_반환() {
        Lotto lotto = new Lotto((List.of(1, 2, 3, 4, 5, 8)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Rank rank = lotto.calculateRank(winningNumbers, 7);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또 등수 반환_4등")
    @Test
    void 번호가_4개_일치하면_4등_반환() {
        Lotto lotto = new Lotto((List.of(1, 2, 3, 4, 7, 8)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Rank rank = lotto.calculateRank(winningNumbers, 7);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("로또 등수 반환_5등")
    @Test
    void 번호가_3개_일치하면_5등_반환() {
        Lotto lotto = new Lotto((List.of(1, 2, 3, 7, 8, 9)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Rank rank = lotto.calculateRank(winningNumbers, 7);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또 등수 반환_꽝")
    @Test
    void 일치하는_번호의_갯수가_2개_이하면_꽝_반환() {
        Lotto lotto = new Lotto((List.of(1, 2, 7, 8, 9, 10)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Rank rank = lotto.calculateRank(winningNumbers, 7);

        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
