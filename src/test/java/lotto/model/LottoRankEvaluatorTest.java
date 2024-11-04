package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoRankEvaluatorTest {
    @Test
    void 로또_당첨_순위를_계산한다_1_등() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(2, 1, 3, 4, 5, 6));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
            assertThat(lottoRankEvaluator.evaluateRank(lotto)).isEqualTo(Rank._1TH);
        });
    }

    @Test
    void 로또_당첨_순위를_계산한다_2_등() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
            assertThat(lottoRankEvaluator.evaluateRank(lotto)).isEqualTo(Rank._2TH);
        });
    }

    @Test
    void 로또_당첨_순위를_계산한다_3_등() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 6));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
            assertThat(lottoRankEvaluator.evaluateRank(lotto)).isEqualTo(Rank._3TH);
        });
    }

    @Test
    void 로또_당첨_순위를_계산한다_4_등() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 7));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
            assertThat(lottoRankEvaluator.evaluateRank(lotto)).isEqualTo(Rank._4TH);
        });
    }

    @Test
    void 로또_당첨_순위를_계산한다_5_등() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 10, 11));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
            assertThat(lottoRankEvaluator.evaluateRank(lotto)).isEqualTo(Rank._5TH);
        });
    }

    @Test
    void 로또_당첨_순위를_계산한다_꼴등() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 10, 11, 12, 7));
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(7)
            );
            LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);
            assertThat(lottoRankEvaluator.evaluateRank(lotto)).isEqualTo(Rank.LAST);
        });
    }
}
