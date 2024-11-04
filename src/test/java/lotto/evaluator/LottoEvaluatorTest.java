package lotto.evaluator;

import lotto.model.LottoRank;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoEvaluatorTest {

    private final LottoEvaluator evaluator = new LottoEvaluator();
    private final Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("1등 당첨 평가")
    void 당첨_1등_평가() {
        // given
        Lotto ticket = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        LottoRank rank = evaluator.evaluate(ticket, winningLotto, -1);

        // then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("2등 및 3등 당첨 평가")
    void 당첨_2등과_3등_평가() {
        // given
        Lotto ticket = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        // when
        LottoRank rankWithoutBonus = evaluator.evaluate(ticket, winningLotto, -1);
        LottoRank rankWithBonus = evaluator.evaluate(ticket, winningLotto, 7);

        // then
        assertThat(rankWithoutBonus).isEqualTo(LottoRank.THIRD);
        assertThat(rankWithBonus).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("4등 당첨 평가")
    void 당첨_4등_평가() {
        // given
        Lotto ticket = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        LottoRank rank = evaluator.evaluate(ticket, winningLotto, -1);

        // then
        assertThat(rank).isEqualTo(LottoRank.FIFTH); // matches 4 numbers
    }

    @Test
    @DisplayName("꽝 평가")
    void 꽝_평가() {
        // given
        Lotto ticket = new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11));

        // when
        LottoRank rank = evaluator.evaluate(ticket, winningLotto, -1);

        // then
        assertThat(rank).isEqualTo(LottoRank.NONE); // matches 3 numbers
    }
}
