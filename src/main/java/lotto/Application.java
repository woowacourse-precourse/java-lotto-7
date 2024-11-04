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
import lotto.model.WinningNumber;
import lotto.model.WinningNumberGenerator;
import lotto.service.TicketService;
import lotto.temp.IoComponent;
import lotto.util.CommonIo;

import java.util.List;
import java.util.Map;

import static lotto.util.RepeatInput.repeatUntilValid;

public class Application {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        CommonIo commonIo = new CommonIo();
        IoComponent ioComponent = new IoComponent(commonIo);
        PurchaseController purchaseController = new PurchaseController(ticketService, ioComponent);
        purchaseController.purchaseLottos();

        LottoGenerator lottoGenerator = new LottoGenerator();

        LottoController lottoController = new LottoController(ticketService, lottoGenerator);

        List<Lotto> lottos = lottoController.excuteLottos();

        ioComponent.getIoController().printPurchaseLottoNumbers(lottos);

        WinningNumberGenerationController winningNumberGenerationController =
                new WinningNumberGenerationController(new WinningNumberGenerator(), ioComponent);
        BonusNumberController bonusNumberController = new BonusNumberController(ioComponent);

        WinningNumber winningNumber = repeatUntilValid(() -> {
            Lotto winningNumbers = winningNumberGenerationController.createWinningNumber();
            BonusNumber bonusNumber = bonusNumberController.createBonusNumber();
            return new WinningNumber(winningNumbers, bonusNumber);
        }, ioComponent.getCommonIo());

        RankCalculatorController rankCalculatorController = new RankCalculatorController(winningNumber,ioComponent);

        Map<Rank,Integer> result = rankCalculatorController.calculateResult(lottos);

        rankCalculatorController.printResult(result);
        float profit = rankCalculatorController.calculateProfit(result, ticketService.getTicketCount());

        ioComponent.getOutputView().printProfit(profit);

    }
}
