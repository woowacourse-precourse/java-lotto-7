package lotto.lotto.domain;

import lotto.money.service.LottoPurchaseCalculator;
import lotto.lotto.service.LottoGenerator;
import lotto.money.domain.Money;
import lotto.view.output.service.PurchaseCountViewService;

public class LottoMachine {
    private final LottoPurchaseCalculator lottoPurchaseCalculator;
    private final LottoGenerator lottoGenerator;
    private final PurchaseCountViewService purchaseCountOutput;
    public LottoMachine(
            LottoPurchaseCalculator lottoPurchaseCalculator,
            LottoGenerator lottoGenerator,
            PurchaseCountViewService purchaseCountOutput) {
        this.lottoPurchaseCalculator = lottoPurchaseCalculator;
        this.lottoGenerator = lottoGenerator;
        this.purchaseCountOutput =purchaseCountOutput;
    }
    private int purchaseCount(Money money) {
        int count = lottoPurchaseCalculator.calculate(money);
        purchaseCountOutput.view(count);
        return count;
    }
    public LottoTickets purchaseLottoTickets(Money money) {
        int count = purchaseCount(money);
        return lottoGenerator.lottoTickets(count);
    }
    public WinningLotto createWinningLotto() {
        return lottoGenerator.winningLotto();
    }
    public BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return lottoGenerator.bonusNumber(winningLotto);
    }
}
