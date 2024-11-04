package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.LottoPrize;
import lotto.model.domain.LottoPrizes;
import lotto.model.domain.LottoWinning;
import lotto.model.domain.Lottos;
import lotto.model.domain.ProfitRatio;
import lotto.model.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void 구매금액만큼_로또_생성() {
        //given
        int lottoPurchaseAmount = 5000;

        //when
        Lottos lottos = lottoService.createLottos(new PurchaseAmount(lottoPurchaseAmount));

        //then
        assertThat(lottos.getSize()).isEqualTo(5);
    }

    @Test
    void 당첨자_뽑기() {
        //given
        Lottos lottos = new Lottos(7);
        List<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber = 7;
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        LottoWinning winning = new LottoWinning(winningNumbers, new BonusNumber(bonusNumber));

        //when
        LottoPrizes lottoPrizes = lottoService.drawWinners(lottos, winning);

        //then
        assertThat(lottoPrizes).isNotNull();
    }

    @Test
    public void 상금_수익률_계산() {
        //given
        List<LottoPrize> prizes = new ArrayList<>();
        prizes.add(LottoPrize.FIFTH);
        prizes.add(LottoPrize.FOURTH);
        int purchaseAmount = 7000;
        LottoPrizes lottoPrizes = new LottoPrizes(prizes);

        //when
        ProfitRatio profitRatio = lottoService.getProfitRatio(new PurchaseAmount(purchaseAmount), lottoPrizes);

        //then
        double expectedRatio = 785.7;
        assertThat(profitRatio.get()).isEqualTo(expectedRatio);

    }

}