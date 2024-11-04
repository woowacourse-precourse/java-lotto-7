package lotto;

import lotto.controller.BonusNumberController;
import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.controller.RankCalculatorController;
import lotto.controller.WinningNumberGenerationController;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Rank;
import lotto.model.RankCalculator;
import lotto.model.WinningNumber;
import lotto.model.WinningNumberGenerator;
import lotto.service.TicketService;
import lotto.temp.ControllerFactory;
import lotto.temp.IoComponent;
import lotto.temp.LottoComponent;
import lotto.util.CommonIo;

import java.util.List;
import java.util.Map;

import static lotto.util.RepeatInput.repeatUntilValid;

public class Application {
    public static void main(String[] args) {
        CommonIo commonIo = new CommonIo();
        IoComponent ioComponent = new IoComponent(commonIo);

        LottoComponent lottoComponent = new LottoComponent(
                new TicketService(),
                new LottoGenerator(),
                new RankCalculator(),
                new WinningNumberGenerator()
        );

        ControllerFactory controllerFactoryFactory = new ControllerFactory(ioComponent, lottoComponent);

        PurchaseController purchaseController = controllerFactoryFactory.createPurchaseController();
        purchaseController.purchaseLottos();


        LottoController lottoController = controllerFactoryFactory.createLottoController();

        List<Lotto> lottos = lottoController.excuteLottos();

        ioComponent.getIoController().printPurchaseLottoNumbers(lottos);

        WinningNumberGenerationController winningNumberGenerationController =
               controllerFactoryFactory.createWinningNumberController();
        BonusNumberController bonusNumberController = controllerFactoryFactory.createBonusNumberController();

        WinningNumber winningNumber = repeatUntilValid(() -> {
            Lotto winningNumbers = winningNumberGenerationController.createWinningNumber();
            BonusNumber bonusNumber = bonusNumberController.createBonusNumber();
            return new WinningNumber(winningNumbers, bonusNumber);
        }, ioComponent.getCommonIo());

        RankCalculatorController rankCalculatorController = controllerFactoryFactory.createRankCalculatorController(winningNumber);

        Map<Rank,Integer> result = rankCalculatorController.calculateResult(lottos);

        rankCalculatorController.printResult(result);
        float profit = rankCalculatorController.calculateProfit(result, lottoComponent.getTicketService().getTicketCount());

        ioComponent.getOutputView().printProfit(profit);

    }
}
