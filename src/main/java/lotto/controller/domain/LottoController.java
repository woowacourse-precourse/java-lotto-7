package lotto.controller.domain;

import lotto.buyer.domain.Buyer;
import lotto.buyer.domain.Money;
import lotto.lotto.domain.LottoMachine;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.winning.domain.Benefit;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningCalculator;
import lotto.lotto.winning.domain.WinningLotto;
import lotto.view.output.domain.ResultViewService;

public class LottoController {
    private final Buyer buyer;
    private final LottoMachine lottoMachine;
    private final ResultViewService resultViewService;
    private final WinningLottoController winningLottoController;
    private final WinningCalculator winningCalculator;

    public LottoController(
            Buyer buyer,
            LottoMachine lottoMachine,
            ResultViewService resultViewService,
            WinningLottoController winningLottoController,
            WinningCalculator winningCalculator) {
        this.buyer = buyer;
        this.lottoMachine = lottoMachine;
        this.resultViewService = resultViewService;
        this.winningLottoController = winningLottoController;
        this.winningCalculator = winningCalculator;
    }

    public void run() {
        Money purchaseMoney = insertMoney();
        LottoTickets lottoTickets = purchaseLottoTickets(purchaseMoney);
        WinningLotto winningLotto = createWinningLotto();
        BonusNumber bonusNumber = createBonusNumber(winningLotto);
        Benefit benefit = updateBenefit(lottoTickets, winningLotto, bonusNumber);
        resultViewService.viewByWinningStatistic(benefit, purchaseMoney);
    }

    private Money insertMoney() {
        Money money = buyer.insertMoney();
        resultViewService.viewByInsertMoney(money);
        return money;
    }

    private LottoTickets purchaseLottoTickets(Money money) {
        LottoTickets lottoTickets = lottoMachine.purchaseLottoTickets(money);
        resultViewService.viewByLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private BonusNumber createBonusNumber(WinningLotto winningLotto) {
        BonusNumber bonusNumber = winningLottoController.createBonusNumber(winningLotto);
        resultViewService.viewByBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private WinningLotto createWinningLotto() {
        WinningLotto winningLotto = winningLottoController.createWinningLotto();
        resultViewService.viewByWinningLotto(winningLotto);
        return winningLotto;

    }

    private Benefit updateBenefit(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return winningCalculator.updateBenefit(lottoTickets, winningLotto, bonusNumber);

    }
}
