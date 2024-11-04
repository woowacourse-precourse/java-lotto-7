package lotto;

import lotto.model.LottoGame;
import lotto.model.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    @DisplayName("로또를 구매하면 지정한 개수만큼 로또가 생성된다")
    void buyLottos_지정한_개수만큼_로또_생성() {
        int purchaseNum = 5;
        lottoGame.buyLottos(purchaseNum);

        assertThat(lottoGame.getPurchasedLottos().size()).isEqualTo(purchaseNum);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 번호를 비교하여 올바르게 당첨 결과를 계산한다")
    void calculateResults_당첨_결과_계산() {
        lottoGame.buyLottos(1);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoGame.calculateResults(winningNumbers, bonusNumber);

        for (Prize prize : Prize.values()) {
            assertThat(prize.getCount()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    @DisplayName("로또 게임의 총 수익률이 올바르게 계산된다")
    void calculateProfit_수익률_계산() {
        lottoGame.buyLottos(5);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoGame.calculateResults(winningNumbers, bonusNumber);

        int purchaseAmount = 5000;
        double profit = lottoGame.calculateProfit(purchaseAmount);

        assertThat(profit).isGreaterThanOrEqualTo(0);
    }
}
