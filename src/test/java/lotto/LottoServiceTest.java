package lotto;

import java.util.List;
import lotto.config.LottoRank;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoResult;
import lotto.model.domain.WinningLotto;
import lotto.model.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    @DisplayName("로또 당첨 결과가 올바르게 계산되어야 한다.")
    @Test
    void 당첨결과_확인() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult result = LottoService.calculateResult(purchasedLottos, winningLotto);

        assertThat(result.getRankCounts().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getRankCounts().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getRankCounts().get(LottoRank.NONE)).isEqualTo(1);
    }

    @DisplayName("총 구입 금액과 당첨금으로 정확한 수익률이 계산되어야 한다.")
    @Test
    void 수익률_계산_정확성_확인() {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(LottoRank.FIRST);  // 1등: 2,000,000,000원
        lottoResult.addRank(LottoRank.SECOND); // 2등: 30,000,000원
        lottoResult.addRank(LottoRank.FOURTH); // 4등: 50,000원

        int totalPurchaseAmount = 3000; // 총 구입 금액

        // when
        double profitRate = lottoResult.calculateProfitRate(totalPurchaseAmount);

        // then
        double expectedProfitRate = (2_000_000_000 + 30_000_000 + 50_000) * 100.0 / totalPurchaseAmount;
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}