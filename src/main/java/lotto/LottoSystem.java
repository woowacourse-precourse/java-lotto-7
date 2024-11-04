package lotto;

import static lotto.constant.PurchaseConfig.PURCHASE_UNIT;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.model.LottosPrizeCount;
import lotto.service.LottoPrize;
import lotto.service.LottoTicketing;
import lotto.util.InputHandler;
import lotto.util.OutputHandler;

public class LottoSystem {
    public void run() {
        Purchase purchase = settingPurchase();
        Lottos lottos = settingLottos(purchase);

        Lotto lotto = getWinningLottoNumbers();
        Bonus bonus = getBonusNumber(lotto);

        LottoPrize lottoPrize = new LottoPrize(lotto, bonus);
        LottosPrizeCount lottosPrizeCount = lottoPrize.determineLottoPrizes(lottos);
        Double rateOfReturn = lottoPrize.calculateRateOfReturn(lottosPrizeCount, purchase);

        printLottoSummary(lottosPrizeCount, rateOfReturn);
    }

    private Purchase settingPurchase() {
        Purchase purchase = InputHandler.repeatInputOrderCost();
        int count = purchase.getCost() / PURCHASE_UNIT;
        OutputHandler.printCount(count);
        return purchase;
    }

    private Lottos settingLottos(Purchase purchase) {
        LottoTicketing lottoTicketing = new LottoTicketing();
        Lottos lottos = lottoTicketing.issueTickets(purchase);
        OutputHandler.printTicket(lottos);
        return lottos;
    }

    private static Lotto getWinningLottoNumbers() {
        return InputHandler.repeatInputLottoNumber();
    }

    private static Bonus getBonusNumber(Lotto lotto) {
        return InputHandler.repeatInputBonusNumber(lotto);
    }

    private static void printLottoSummary(LottosPrizeCount lottosPrizeCount, Double rateOfReturn) {
        OutputHandler.printLottoResult(lottosPrizeCount);
        OutputHandler.printRateOfReturn(rateOfReturn);
    }
}
