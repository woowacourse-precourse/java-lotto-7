package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private static Lotto lotto;

    @BeforeAll
    static void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

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
    void 일치하는_번호가_6개라면_first_rank를_반환한다() {
        WinningLotto firstLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lotto.calculateRank(firstLotto).get()).isEqualTo(Rank.FIRST);
    }

    @Test
    void 일치하는_번호가_5개에_보너스_번호를_맞췄다면_second_rank를_반환한다() {
        WinningLotto secondLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 6);
        assertThat(lotto.calculateRank(secondLotto).get()).isEqualTo(Rank.SECOND);
    }

    @Test
    void 일치하는_번호가_5개라면_third_rank를_반환한다() {
        WinningLotto thirdLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 8), 7);
        assertThat(lotto.calculateRank(thirdLotto).get()).isEqualTo(Rank.THIRD);
    }

    @Test
    void 일치하는_번호가_4개라면_fourth_rank를_반환한다() {
        WinningLotto fourthLotto = new WinningLotto(List.of(1, 2, 3, 4, 8, 9), 7);
        assertThat(lotto.calculateRank(fourthLotto).get()).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 일치하는_번호가_3개라면_fifth_rank를_반환한다() {
        WinningLotto fifthLotto = new WinningLotto(List.of(1, 2, 3, 8, 9, 10), 7);
        assertThat(lotto.calculateRank(fifthLotto).get()).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 일치하는_번호가_없으면_optional_empty를_반환한다() {
        WinningLotto fifthLotto = new WinningLotto(List.of(1, 2, 8, 9, 10, 11), 7);
        assertThat(lotto.calculateRank(fifthLotto)).isEmpty();
    }
}
