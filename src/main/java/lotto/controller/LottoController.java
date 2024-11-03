package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.money.PurchaseAmount;
import lotto.domain.rank.LottoRanks;
import lotto.exception.LottoApplicationException;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoView lottoView;

    public LottoController(LottoService lottoService, LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void run() {
        Money money = getMoneyFromUser();

        List<Lotto> purchasedLottos = purchaseLotto(money);
        WinningLotto winningLotto = getWinningLottoFromUser();

        LottoRanks lottoRanks = lottoService.compareLottos(winningLotto, purchasedLottos);
        double rateOfReturn = lottoRanks.calculateTotalReturnRate(money);

        lottoView.showWinningStatistics(lottoRanks.getRanks(), rateOfReturn);
    }

    private Money getMoneyFromUser() {
        PurchaseAmount purchaseAmount = repeatUntilCorrectInput(lottoView::getPurchaseAmountFromUser);
        return purchaseAmount.toMoney();
    }

    private List<Lotto> purchaseLotto(Money money) {
        List<Lotto> lottos = lottoService.purchaseBy(money);
        lottoView.showPurchasedLottos(lottos);
        return lottos;
    }

    private WinningLotto getWinningLottoFromUser() {
        Lotto lotto = repeatUntilCorrectInput(lottoView::getWinningNumbersFromUser);
        return repeatUntilCorrectInput(() -> getWinningLottoFromUser(lotto));
    }

    private WinningLotto getWinningLottoFromUser(Lotto lotto) {
        LottoNumber bonusNumber = lottoView.getBonusNumberFromUser();
        return new WinningLotto(lotto, bonusNumber);
    }

    private <T> T repeatUntilCorrectInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (LottoApplicationException e) {
                lottoView.showLottoApplicationException(e);
            }
        }
    }

}
