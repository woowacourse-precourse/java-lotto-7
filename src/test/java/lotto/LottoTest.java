package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
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
    void 로또_번호가_1부터_45사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_6개_일치하면_1등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoRank rank = lotto.getRank(winNumbers, bonusNumber);

        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 로또_번호가_5개_일치하고_보너스_번호가_일치하면_2등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 6;

        LottoRank rank = lotto.getRank(winNumbers, bonusNumber);

        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 로또_번호가_5개_일치하면_3등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 8;

        LottoRank rank = lotto.getRank(winNumbers, bonusNumber);

        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 로또_번호가_4개_일치하면_4등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winNumbers = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        int bonusNumber = 9;

        LottoRank rank = lotto.getRank(winNumbers, bonusNumber);

        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 로또_번호가_3개_일치하면_5등이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winNumbers = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonusNumber = 10;

        LottoRank rank = lotto.getRank(winNumbers, bonusNumber);

        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 로또_번호가_2개_이하로_일치하면_꽝이다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winNumbers = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        int bonusNumber = 11;

        LottoRank rank = lotto.getRank(winNumbers, bonusNumber);

        assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}
