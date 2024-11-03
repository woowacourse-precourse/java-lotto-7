package lotto;

import lotto.controller.BonusNumberController;
import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.controller.WinningController;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.service.TicketService;
import lotto.temp.IoController;
import lotto.temp.Winning;
import lotto.util.CommonIo;

public class Application {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        PurchaseController purchaseController = new PurchaseController(ticketService);
        purchaseController.purchaseLottos();

        LottoController lottoController = new LottoController(ticketService);
        IoController ioController = new IoController(new CommonIo());

        ioController.printPurchaseLottoNumbers(lottoController.excuteLottos());

        WinningController winningController = new WinningController(new Winning());
        BonusNumberController bonusNumberController = new BonusNumberController();

        Lotto winningNumbers = winningController.createWinningNumber();
        BonusNumber bonusNumber = bonusNumberController.createBonusNumber();

    }
}
