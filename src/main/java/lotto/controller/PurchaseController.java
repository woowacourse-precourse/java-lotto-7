package lotto.controller;

import lotto.model.PurchaseModel;
import lotto.view.PurchaseView;
import lotto.service.PurchaseService;

public class PurchaseController {
    private PurchaseService service = new PurchaseService();
    private PurchaseView view = new PurchaseView();

    public int run() {
        int price = view.inputPrice();
        int ticketCount = service.getTicketCount(price);
        PurchaseModel model = new PurchaseModel(ticketCount);

        return model.getTicketCount();
    }

}
