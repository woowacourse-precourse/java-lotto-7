package lotto;

import lotto.constant.LottoConfig;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.service.LottoPrize;
import lotto.service.LottoTicketing;
import lotto.util.InputHandler;
import lotto.util.OutputHandler;
import java.util.Map;

import static lotto.constant.PurchaseConfig.PURCHASE_UNIT;

public class LottoSystem {
    public void run() {
        Purchase purchase = InputHandler.repeatInputOrderCost();

        LottoTicketing lottoTicketing = new LottoTicketing();
        Lottos lottos = lottoTicketing.issueTickets(purchase);
        int count = purchase.getCost() / PURCHASE_UNIT;

        OutputHandler.printCount(count);
        OutputHandler.printTicket(lottos);

        Lotto lotto = InputHandler.repeatInputLottoNumber();
        Bonus bonus = InputHandler.repeatInputBonusNumber(lotto);

        LottoPrize lottoPrize = new LottoPrize(lotto, bonus);
        Map<LottoConfig.Rank, Integer> result = lottoPrize.determineLottoPrizes(lottos);
        Double rateOfReturn = lottoPrize.calculateRateOfReturn(result, purchase);

        OutputHandler.printLottoResult(result);
        OutputHandler.printRateOfReturn(rateOfReturn);
    }
}
