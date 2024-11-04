package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoGameTest {

    private LottoPrice lottoPrice;
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoPrice = new LottoPrice(1000);
        lottoGame = new LottoGame(lottoPrice);
    }

    @Test
    void 천원당_로또_한장을_구매할_수_있다() {

        lottoGame.buyLotto();

        assertThat(lottoGame.getLottos()).hasSize(1);
    }

    @Test
    void 구매한_로또의_당첨_여부를_확인할_수_있다() {

        lottoGame.buyLotto();
        List<Lotto> purchasedLottos = lottoGame.getLottos();

        List<LottoNumber> purchasedNumbers = purchasedLottos.get(0).getNumbers();

        LottoNumber bonusNumber = new LottoNumber(45);
        while (purchasedNumbers.contains(bonusNumber)) {
            bonusNumber = new LottoNumber(bonusNumber.number() - 1);
        }

        WinningLotto winningLotto = new WinningLotto(new Lotto(purchasedNumbers), bonusNumber);

        lottoGame.checkWinningLotto(winningLotto);

        Map<LottoPrize, Integer> prizeCounts = lottoGame.getPrizeCounts();
        int firstPrizeCount = prizeCounts.getOrDefault(LottoPrize.FIRST, 0);
        assertThat(firstPrizeCount).isEqualTo(1);
    }

    @Test
    void 총_수익률을_확인할_수_있다() {

        lottoGame.buyLotto();
        List<Lotto> purchasedLottos = lottoGame.getLottos();

        List<LottoNumber> purchasedNumbers = purchasedLottos.get(0).getNumbers();

        LottoNumber bonusNumber = new LottoNumber(45);
        while (purchasedNumbers.contains(bonusNumber)) {
            bonusNumber = new LottoNumber(bonusNumber.number() - 1);
        }

        WinningLotto winningLotto = new WinningLotto(new Lotto(purchasedNumbers), bonusNumber);

        lottoGame.checkWinningLotto(winningLotto);

        double profit = lottoGame.calculateProfit();
        assertThat(profit).isEqualTo(200000000.0);
    }
}
