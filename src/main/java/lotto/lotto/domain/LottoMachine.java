package lotto.lotto.domain;

import lotto.calculator.domain.Calculator;
import lotto.lotto.service.LottoGenerator;
import lotto.money.domain.Money;
import lotto.view.output.domain.PurchaseCountViewService;

public class LottoMachine {
    private final Calculator divideThousandCalculator;
    private final LottoGenerator lottoGenerator;
    private final PurchaseCountViewService purchaseCountOutput;
    public LottoMachine(
            Calculator divideThousandCalculator,
            LottoGenerator lottoGenerator,
            PurchaseCountViewService purchaseCountOutput) {
        this.divideThousandCalculator = divideThousandCalculator;
        this.lottoGenerator = lottoGenerator;
        this.purchaseCountOutput =purchaseCountOutput;
    }
    private int purchaseCount(Money money) {
        int count = divideThousandCalculator.calculate(money);
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
