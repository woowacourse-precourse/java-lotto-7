package lotto.controller.service;

import lotto.buyer.domain.Buyer;
import lotto.buyer.domain.InsertMoneyService;
import lotto.buyer.infrastructure.InsertPurchaseMoney;
import lotto.controller.domain.LottoController;
import lotto.lotto.domain.*;
import lotto.lotto.infrastructure.LottoCreator;
import lotto.lotto.infrastructure.PurchaseLottoTickets;
import lotto.money.domain.BenefitCreatorService;
import lotto.money.infrastructure.BenefitCreator;
import lotto.money.infrastructure.WinningAmountCalculator;
import lotto.lotto.infrastructure.RandomNumberGenerate;
import lotto.calculator.infrastructure.DivideThousandCalculator;
import lotto.lotto.winning.infrastructure.BonusNumberCreator;
import lotto.lotto.winning.infrastructure.WinningLottoCreator;
import lotto.view.input.hanlder.infrastructure.BonusNumberHandler;
import lotto.view.input.hanlder.infrastructure.MoneyHandler;
import lotto.view.input.hanlder.infrastructure.WinningLottoHandler;
import lotto.view.input.infrastructure.BonusNumberInput;
import lotto.view.input.infrastructure.MoneyInput;
import lotto.view.input.infrastructure.WinningLottoInput;
import lotto.view.output.domain.ResultViewService;
import lotto.view.output.infrastructure.*;

public class LottoControllerFactory {
    public static LottoController create() {
        Buyer buyer = createBuyer();
        LottoMachine lottoMachine = createLottoMachine();
        BenefitCreatorService benefitCreator = createBenefitCreator();
        ResultViewService resultViewService = createResultViewService();
        return new LottoController(buyer, lottoMachine, benefitCreator, resultViewService);
    }

    private static Buyer createBuyer() {
        InsertMoneyService insertMoneyService = new InsertPurchaseMoney(new MoneyHandler(new MoneyInput(new MoneyOutput())));
        return new Buyer(insertMoneyService);
    }

    private static LottoMachine createLottoMachine() {
        PurchaseLottoTicketsService lottoTicketsCreator = new PurchaseLottoTickets(new RandomNumberGenerate());
        WinningLottoCreatorService winningLottoCreator = new WinningLottoCreator(new WinningLottoHandler(new WinningLottoInput(new WinningLottoOutput())));
        BonusNumberCreatorService bonusNumberCreator = new BonusNumberCreator(new BonusNumberHandler(new BonusNumberInput(new BonusNumberOutput())));
        LottoCreatorService lottoCreatorService = new LottoCreator(lottoTicketsCreator, winningLottoCreator, bonusNumberCreator);
        return new LottoMachine(new DivideThousandCalculator(), lottoCreatorService, new PurchaseOutput());
    }

    private static ResultViewService createResultViewService() {
        return new CommonResultOutput();
    }

    private static BenefitCreator createBenefitCreator() {
        return new BenefitCreator(new WinningAmountCalculator());
    }
}
