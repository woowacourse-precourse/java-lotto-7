package lotto;

import lotto.controller.PurchaseController;
import lotto.service.TicketService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TicketService ticketService = new TicketService();
        PurchaseController purchaseController = new PurchaseController(ticketService);
        purchaseController.purchaseLottos();
    }
}
