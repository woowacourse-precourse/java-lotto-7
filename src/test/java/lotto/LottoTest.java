package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 로또_번호는_1에서_45사이여야_한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_3개미만일때_RANK는_NONE이다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer rank = lotto.getLottoRank(Arrays.asList(7, 8, 9, 10, 11, 12), null);
        assertEquals(LottoRank.NONE.getRank(), rank);
    }

    @Test
    void 당첨_번호_3개일때_RANK는_FIFTH이다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer rank = lotto.getLottoRank(Arrays.asList(1, 2, 3, 10, 11, 12), null);
        assertEquals(LottoRank.FIFTH.getRank(), rank);
    }

    @Test
    void 당첨_번호_4개일때_RANK는_FOURTH이다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer rank = lotto.getLottoRank(Arrays.asList(1, 2, 3, 4, 11, 12), null);
        assertEquals(LottoRank.FOURTH.getRank(), rank);
    }

    @Test
    void 당첨_번호_5개일때_RANK는_THIRD이다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer rank = lotto.getLottoRank(Arrays.asList(1, 2, 3, 4, 5, 12), null);
        assertEquals(LottoRank.THIRD.getRank(), rank);
    }

    @Test
    void 당첨_번호_5개이고_보너스_번호가_일치하면_RANK는_SECOND이다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer rank = lotto.getLottoRank(Arrays.asList(1, 2, 3, 4, 5, 12), 6);
        assertEquals(LottoRank.SECOND.getRank(), rank);
    }

    @Test
    void 당첨_번호_6개일때_RANK는_FIRST이다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer rank = lotto.getLottoRank(Arrays.asList(1, 2, 3, 4, 5, 6), null);
        assertEquals(LottoRank.FIRST.getRank(), rank);
    }
}
