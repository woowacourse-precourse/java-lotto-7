package lotto.service;

import lotto.constant.Rank;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyAmount;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private TestLottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new TestLottoService();
    }

    @DisplayName("고정된 난수 값으로 로또 구매 테스트")
    @Test
    void 로또_구매_테스트() {
        LottoBuyAmount amount = new LottoBuyAmount(5000);
        List<Lotto> lottos = lottoService.buyLottos(amount);

        assertThat(lottos).hasSize(amount.getLottoBuyCount());
        assertThat(lottos.getFirst().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("고정된 난수 값으로 로또 결과 및 수익률 계산 테스트")
    @Test
    void 로또_결과_및_수익률_계산_테스트() {
        LottoBuyAmount amount = new LottoBuyAmount(1000);
        lottoService.buyLottos(amount);

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningLotto.getWinningNumbers());

        LottoResult result = lottoService.calculateResult(winningLotto, bonusNumber);
        double profitRate = result.getProfitRate();

        double expectedProfitRate = (double) Rank.SIX_MATCH.getWinnings() / 1000 * 100;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
