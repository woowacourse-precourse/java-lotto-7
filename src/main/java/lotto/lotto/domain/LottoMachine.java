package lotto.lotto.domain;

import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;
import lotto.money.domain.Money;
import lotto.view.output.domain.PurchaseCountViewService;

public class LottoMachine {
    private final Calculator divideThousandCalculator;
    private final LottoCreatorService lottoCreator;
    private final PurchaseCountViewService purchaseCountOutput;
    public LottoMachine(Calculator divideThousandCalculator, LottoCreatorService lottoCreator, PurchaseCountViewService purchaseCountOutput) {
        this.divideThousandCalculator = divideThousandCalculator;
        this.lottoCreator = lottoCreator;
        this.purchaseCountOutput =purchaseCountOutput;
    }
    private int purchaseCount(Money money) {
        int count = divideThousandCalculator.calculate(money);
        purchaseCountOutput.view(count);
        return count;
    }
    public LottoTickets purchaseLottoTickets(Money money) {
        int count = purchaseCount(money);
        return lottoCreator.createLottoTickets(count);
    }
    public WinningLotto createWinningLotto() {
        return lottoCreator.createWinningLotto();
    }
    public BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return lottoCreator.createBonusNumber(winningLotto);
    }
}
