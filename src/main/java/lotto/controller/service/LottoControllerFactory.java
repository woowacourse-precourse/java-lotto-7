package lotto.controller.service;

import lotto.buyer.domain.Buyer;
import lotto.buyer.domain.InsertMoneyService;
import lotto.buyer.infrastructure.InsertPurchaseMoney;
import lotto.controller.domain.LottoController;
import lotto.lotto.domain.BonusNumberCreatorService;
import lotto.lotto.domain.LottoMachine;
import lotto.lotto.domain.PurchaseLottoTicketsService;
import lotto.lotto.domain.WinningLottoCreatorService;
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
        InsertMoneyService insertMoneyService = createInsertMoneyService();
        Buyer buyer = createBuyer(insertMoneyService);
        LottoMachine lottoMachine = createLottoMachine();
        BenefitCreatorService benefitCreator = createBenefitCreator();
        ResultViewService resultViewService = createResultViewService();
        return new LottoController(buyer, lottoMachine, benefitCreator, resultViewService);
    }

    private static InsertMoneyService createInsertMoneyService() {
        return new InsertPurchaseMoney(new MoneyHandler(new MoneyInput(new MoneyOutput())));
    }

    private static Buyer createBuyer(InsertMoneyService insertMoneyService) {
        return new Buyer(insertMoneyService);
    }

    private static WinningLottoCreator createWinningLottoCreator() {
        return new WinningLottoCreator(new WinningLottoHandler(new WinningLottoInput(new WinningLottoOutput())));
    }
    private static BonusNumberCreator createBonusNumberCreator() {
        return new BonusNumberCreator(new BonusNumberHandler(new BonusNumberInput(new BonusNumberOutput())));
    }
    private static PurchaseLottoTickets createLottoTicketsCreator() {
        return new PurchaseLottoTickets(new RandomNumberGenerate());
    }
    private static LottoCreator createLottoCreator() {
        PurchaseLottoTicketsService lottoTicketsCreator = createLottoTicketsCreator();
        WinningLottoCreatorService winningLottoCreator = createWinningLottoCreator();
        BonusNumberCreatorService bonusNumberCreator = createBonusNumberCreator();
        return new LottoCreator(lottoTicketsCreator, winningLottoCreator, bonusNumberCreator);
    }
    private static LottoMachine createLottoMachine() {
        LottoCreator lottoCreator = createLottoCreator();
        return new LottoMachine(new DivideThousandCalculator(), lottoCreator, new PurchaseOutput());
    }

    private static ResultViewService createResultViewService() {
        return new CommonResultOutput();
    }

    private static BenefitCreator createBenefitCreator() {
        return new BenefitCreator(new WinningAmountCalculator());
    }
}
