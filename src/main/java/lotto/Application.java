package lotto;

import lotto.controller.BonusNumberController;
import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.controller.RankCalculatorController;
import lotto.controller.WinningNumberGenerationController;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumber;
import lotto.service.TicketService;
import lotto.temp.IoController;
import lotto.model.WinningNumberGenerator;
import lotto.util.CommonIo;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        PurchaseController purchaseController = new PurchaseController(ticketService);
        purchaseController.purchaseLottos();

        LottoController lottoController = new LottoController(ticketService);
        IoController ioController = new IoController(new CommonIo());

        List<Lotto> lottos = lottoController.excuteLottos();

        ioController.printPurchaseLottoNumbers(lottos);

        WinningNumberGenerationController winningNumberGenerationController = new WinningNumberGenerationController(new WinningNumberGenerator());
        BonusNumberController bonusNumberController = new BonusNumberController();

        Lotto winningNumbers = winningNumberGenerationController.createWinningNumber();
        BonusNumber bonusNumber = bonusNumberController.createBonusNumber();

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

        RankCalculatorController rankCalculatorController = new RankCalculatorController(winningNumber);

        Map<Rank,Integer> result = rankCalculatorController.calculateResult(lottos);

        rankCalculatorController.printResult(result);

    }
}
