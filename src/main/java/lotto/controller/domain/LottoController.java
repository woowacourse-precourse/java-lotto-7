package lotto.controller.domain;

import lotto.buyer.domain.Buyer;
import lotto.money.service.BenefitCalculator;
import lotto.money.domain.Money;
import lotto.lotto.domain.LottoMachine;
import lotto.lotto.domain.LottoTickets;
import lotto.money.domain.Benefit;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;
import lotto.view.output.service.ResultViewService;

public class LottoController {
    private final Buyer buyer;
    private final LottoMachine lottoMachine;
    private final BenefitCalculator benefitCreator;
    private final ResultViewService resultViewService;

    public LottoController(
            Buyer buyer,
            LottoMachine lottoMachine,
            BenefitCalculator benefitCreator,
            ResultViewService resultViewService) {
        this.buyer = buyer;
        this.lottoMachine = lottoMachine;
        this.benefitCreator = benefitCreator;
        this.resultViewService = resultViewService;
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
        BonusNumber bonusNumber = lottoMachine.createBonusNumber(winningLotto);
        resultViewService.viewByBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private WinningLotto createWinningLotto() {
        WinningLotto winningLotto = lottoMachine.createWinningLotto();
        resultViewService.viewByWinningLotto(winningLotto);
        return winningLotto;

    }

    private Benefit updateBenefit(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return benefitCreator.execute(lottoTickets, winningLotto, bonusNumber);

    }
}
