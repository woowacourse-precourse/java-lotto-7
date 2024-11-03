package lotto;

import lotto.controller.BonusNumberController;
import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.controller.WinningNumberGenerationController;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.service.TicketService;
import lotto.temp.IoController;
import lotto.model.WinningNumberGenerator;
import lotto.util.CommonIo;

public class Application {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        PurchaseController purchaseController = new PurchaseController(ticketService);
        purchaseController.purchaseLottos();

        LottoController lottoController = new LottoController(ticketService);
        IoController ioController = new IoController(new CommonIo());

        ioController.printPurchaseLottoNumbers(lottoController.excuteLottos());

        WinningNumberGenerationController winningNumberGenerationController = new WinningNumberGenerationController(new WinningNumberGenerator());
        BonusNumberController bonusNumberController = new BonusNumberController();

        Lotto winningNumbers = winningNumberGenerationController.createWinningNumber();
        BonusNumber bonusNumber = bonusNumberController.createBonusNumber();

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

    }
}
