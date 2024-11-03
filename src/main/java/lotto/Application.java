package lotto;

import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.service.TicketService;
import lotto.temp.IoController;
import lotto.util.CommonIo;

public class Application {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        PurchaseController purchaseController = new PurchaseController(ticketService);
        purchaseController.purchaseLottos();

        LottoController lottoController = new LottoController(ticketService);
        IoController ioController = new IoController(new CommonIo());

        ioController.printPurchaseLottoNumbers(lottoController.excuteLottos());


    }
}
