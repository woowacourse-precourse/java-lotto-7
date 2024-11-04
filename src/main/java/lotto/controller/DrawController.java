package lotto.controller;

import lotto.Lotto;
import lotto.model.PurchaseModel;
import lotto.service.DrawService;
import lotto.service.PurchaseService;
import lotto.view.PurchaseView;

import java.util.ArrayList;

public class DrawController {
    private int ticketCount;
    private DrawService service = new DrawService();

    public DrawController() {
        this.ticketCount = PurchaseModel.getTicketCount();
    }

    public void run() {
        service.createLotto(ticketCount);
        service.printLotto(ticketCount);
    }
}
