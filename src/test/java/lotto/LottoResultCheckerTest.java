package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

public class LottoResultCheckerTest {
    @Test
    void 로또_결과를_확인하여_각_등수별_당첨_횟수를_기록한다() {
        LottoResultChecker resultChecker = new LottoResultChecker();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 5, 13)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        resultChecker.checkLottoResult(purchasedLottos, winningLotto, bonusNumber);

        Map<Prize, Integer> prizeCountMap = resultChecker.getPrizeCountMap();

        assertThat(prizeCountMap.get(Prize.THREE_MATCHES)).isEqualTo(1);
        assertThat(prizeCountMap.get(Prize.FOUR_MATCHES)).isEqualTo(1);
        assertThat(prizeCountMap.get(Prize.FIVE_MATCHES)).isEqualTo(1);
        assertThat(prizeCountMap.get(Prize.FIVE_MATCHES_WITH_BONUS)).isEqualTo(1);
        assertThat(prizeCountMap.get(Prize.SIX_MATCHES)).isEqualTo(1);
    }

    @Test
    void 총_당첨금을_정확하게_계산한다() {
        LottoResultChecker resultChecker = new LottoResultChecker();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );

        resultChecker.checkLottoResult(purchasedLottos, winningLotto, bonusNumber);

        int totalPrize = resultChecker.calculateTotalPrize();
        assertThat(totalPrize).isEqualTo(2000000000 + 30000000 + 5000);
    }

    @Test
    void 총_수익률을_계산한다() {
        LottoResultChecker resultChecker = new LottoResultChecker();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        int lottoPurchaseAmount = 14000;

        resultChecker.checkLottoResult(purchasedLottos, winningLotto, bonusNumber);
        double yield = resultChecker.calculateYield(lottoPurchaseAmount);

        double expectedYield = (double) 2000000000 / (lottoPurchaseAmount * Constants.LOTTO_PRICE) * 100;
        assertThat(yield).isEqualTo(expectedYield);
    }
}
