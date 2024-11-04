package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoInput;
import lotto.service.LottoShop;
import lotto.service.LottoWinning;

import java.util.List;

public class Facade {

    LottoInput lottoInput;
    LottoShop lottoShop;
    LottoWinning lottoWinning;

    public Facade() {
        this.lottoInput = new LottoInput();
        this.lottoShop = new LottoShop();
    }

    public void start() {
        int money = lottoInput.inputMoneyLoop();
        List<Lotto> lottos = purchaseLottos(money);
        List<Integer> winningNumbers = lottoInput.inputWinningNumbersLoop();
        int bonusNumber = lottoInput.inputBonusNumberLoop();
        lottoWinning = new LottoWinning(winningNumbers, bonusNumber, lottos);
        lottoWinning.start();
    }

    private List<Lotto> purchaseLottos(int money) {
        List<Lotto> lottos = lottoShop.purchaseLotto(money);
        for (Lotto lotto : lottos) {
            lotto.showLottoNumbers(); //로또 번호들을 출력
        }
        return lottos;
    }

}
