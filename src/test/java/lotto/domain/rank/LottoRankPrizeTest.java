package lotto.domain.rank;

import lotto.domain.result.LottoResultChecker;
import lotto.ui.parser.InputParser;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankPrizeTest {

    @Test
    void 최종_금액을_반환_테스트() {
        // given
        final List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        final Lotto allMatched = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchedWithBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final Lotto fiveMatched = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        final Lotto fourMatched = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        final Lotto threeMatched = new Lotto(List.of(1, 2, 3, 12, 13, 14));

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);

        final Lottos lottos = new Lottos(List.of(allMatched, fiveMatchedWithBonusNumber, fiveMatched, fourMatched, threeMatched));
        final Lottos lottoRanks = resultChecker.checkLottosRank(lottos);

        // when
        final LottoRankPrize lottoRankPrize = new LottoRankPrize();
        final int result = lottoRankPrize.calculateTotalPrize(lottoRanks);

        // then
        assertThat(result).isEqualTo(2_031_555_000);
    }

    @Test
    void 최종_금액을_반환_테스트_2() {
        // given
        final List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        final Lotto allMatched = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchedWithBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);

        final Lottos lottos = new Lottos(List.of(allMatched, fiveMatchedWithBonusNumber));
        final Lottos lottoRanks = resultChecker.checkLottosRank(lottos);

        // when
        final LottoRankPrize lottoRankPrize = new LottoRankPrize();
        final int result = lottoRankPrize.calculateTotalPrize(lottoRanks);

        // then
        assertThat(result).isEqualTo(2_030_000_000);
    }

    @Test
    void 최종_금액을_반환_테스트_3() {
        // given
        final List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        final Lotto allMatched = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        final Lotto fiveMatchedWithBonusNumber = new Lotto(List.of(21, 22, 23, 24, 25, 27));

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);

        final Lottos lottos = new Lottos(List.of(allMatched, fiveMatchedWithBonusNumber));
        final Lottos lottoRanks = resultChecker.checkLottosRank(lottos);

        // when
        final LottoRankPrize lottoRankPrize = new LottoRankPrize();
        final int result = lottoRankPrize.calculateTotalPrize(lottoRanks);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 최종_금액을_반환_테스트_4() {
        // given
        final List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = 7;

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);

        final Lottos lottos = new Lottos(List.of());
        final Lottos lottoRanks = resultChecker.checkLottosRank(lottos);

        // when
        final LottoRankPrize lottoRankPrize = new LottoRankPrize();
        final int result = lottoRankPrize.calculateTotalPrize(lottoRanks);

        // then
        assertThat(result).isEqualTo(0);
    }
}