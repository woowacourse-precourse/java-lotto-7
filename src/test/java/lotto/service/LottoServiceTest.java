package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @DisplayName("로또 구매 개수 확인")
    @Test
    void lottoPurchaseAmountTest() {
        LottoService lottoService = new LottoService();
        int amount = 8000;

        lottoService.purchaseLottos(amount);

        assertThat(lottoService.getPurchasedLottos()).hasSize(8);
    }

    @DisplayName("당첨 결과 계산 확인")
    @Test
    void resultTest() {
        LottoService lottoService = new LottoService();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        lottoService.getPurchasedLottos().addAll(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5));

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        Map<LottoRank, Integer> results = lottoService.calculateResults(winningNumbers);

        assertThat(results.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(results.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(results.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(results.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(results.get(LottoRank.FIFTH)).isEqualTo(1);
    }
}
