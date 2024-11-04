package lotto;

import lotto.service.InputService;

public class Application {
    private static final int TICKET_PRICE = 1000;
    private static final InputService inputService = new InputService();

    public static void main(String[] args) {
        int purchaseAmount = inputService.inputPurchaseAmount(TICKET_PRICE);
        int purchaseCount = purchaseAmount / TICKET_PRICE;
    }
}
