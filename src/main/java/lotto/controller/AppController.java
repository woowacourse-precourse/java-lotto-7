package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumber;
import lotto.util.ControllerFactory;
import lotto.util.IoComponent;
import lotto.util.LottoComponent;
import lotto.util.common.RepeatInput;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.util.common.RepeatInput.repeatUntilValid;

public class AppController {
    private final ControllerFactory controllerFactory;
    private final IoComponent ioComponent;
    private final LottoComponent lottoComponent;

    public AppController(ControllerFactory controllerFactory, IoComponent ioComponent, LottoComponent lottoComponent) {
        this.controllerFactory = controllerFactory;
        this.ioComponent = ioComponent;
        this.lottoComponent = lottoComponent;
    }

    public void runApplication() {
        List<Lotto> lottos = purchaseLottos();
        WinningNumber winningNumber = createWinningNumber();
        Map<Rank, Integer> result = checkWinning(lottos, winningNumber);
        printResult(result, winningNumber);
    }

    private List<Lotto> purchaseLottos() {
        PurchaseController purchaseController = controllerFactory.createPurchaseController();
        purchaseController.purchaseLottos();

        LottoController lottoController = controllerFactory.createLottoController();
        List<Lotto> lottos = lottoController.excuteLottos();
        ioComponent.getIoController().printPurchaseLottoNumbers(lottos);

        return lottos;
    }

    private Map<Rank, Integer> checkWinning(List<Lotto> lottos, WinningNumber winningNumber) {
        RankCalculatorController rankCalculatorController = controllerFactory
                .createRankCalculatorController(winningNumber);

        return rankCalculatorController.calculateResult(lottos);
    }

    private WinningNumber createWinningNumber() {
        WinningNumberGenerationController winningNumberGenerationController =
                controllerFactory.createWinningNumberController();
        BonusNumberController bonusNumberController = controllerFactory.createBonusNumberController();

        return repeatUntilValid(() -> {
            Lotto winningNumbers = winningNumberGenerationController.createWinningNumber();
            BonusNumber bonusNumber = bonusNumberController.createBonusNumber();
            return new WinningNumber(winningNumbers, bonusNumber);
        }, ioComponent.getCommonIo());
    }

    private void printResult(Map<Rank, Integer> result, WinningNumber winningNumber) {
        RankCalculatorController rankCalculatorController = controllerFactory.createRankCalculatorController(winningNumber);

        rankCalculatorController.printResult(result);
        float profit = rankCalculatorController.calculateProfit(result, lottoComponent.getTicketService().getTicketCount());

        ioComponent.getOutputView().printProfit(profit);
    }
}
