package lotto.controller.service;

import lotto.buyer.domain.Buyer;
import lotto.buyer.service.InsertMoneyService;
import lotto.buyer.infrastructure.UserInputInsertMoney;
import lotto.controller.domain.LottoController;
import lotto.lotto.infrastructure.*;
import lotto.lotto.service.BonusNumberGenerator;
import lotto.lotto.service.LottoGenerator;
import lotto.lotto.domain.LottoMachine;
import lotto.lotto.service.PurchaseLottoTickets;
import lotto.lotto.service.WinningLottoGenerator;
import lotto.money.service.BenefitCalculator;
import lotto.money.infrastructure.WinningBenefitCalculator;
import lotto.money.infrastructure.WinningAmountCalculator;
import lotto.money.infrastructure.DivideThousandCalculator;
import lotto.view.input.hanlder.infrastructure.BonusNumberHandler;
import lotto.view.input.hanlder.infrastructure.MoneyHandler;
import lotto.view.input.hanlder.infrastructure.WinningLottoHandler;
import lotto.view.input.infrastructure.BonusNumberInput;
import lotto.view.input.infrastructure.MoneyInput;
import lotto.view.input.infrastructure.WinningLottoInput;
import lotto.view.output.service.ResultViewService;
import lotto.view.output.infrastructure.*;

public class LottoControllerFactory {
    public static LottoController create() {
        Buyer buyer = createBuyer();
        LottoMachine lottoMachine = createLottoMachine();
        BenefitCalculator benefitCalculator = createBenefitCreator();
        ResultViewService resultViewService = createResultViewService();
        return new LottoController(buyer, lottoMachine, benefitCalculator, resultViewService);
    }

    private static Buyer createBuyer() {
        InsertMoneyService insertMoneyService = new UserInputInsertMoney(new MoneyHandler(new MoneyInput(new MoneyOutput())));
        return new Buyer(insertMoneyService);
    }

    private static LottoMachine createLottoMachine() {
        PurchaseLottoTickets purchaseLottoTickets = new AutoRandomNumberLottoTickets(new RandomNumberGenerator());
        WinningLottoGenerator winningLottoGenerator = new UserInputWinningLottoGenerator(new WinningLottoHandler(new WinningLottoInput(new WinningLottoOutput())));
        BonusNumberGenerator bonusNumberGenerator = new UserInputBonusNumberGenerator(new BonusNumberHandler(new BonusNumberInput(new BonusNumberOutput())));
        LottoGenerator lottoSuite = new LottoSuite(purchaseLottoTickets, winningLottoGenerator, bonusNumberGenerator);
        return new LottoMachine(new DivideThousandCalculator(), lottoSuite, new PurchaseOutput());
    }

    private static ResultViewService createResultViewService() {
        return new LottoResultOutput();
    }

    private static WinningBenefitCalculator createBenefitCreator() {
        return new WinningBenefitCalculator(new WinningAmountCalculator());
    }
}
