package lotto.controller;

import lotto.service.PurchaseAmountService;

public class PurchaseAmountController {
    private final PurchaseAmountService purchaseAmountService;

    public PurchaseAmountController(PurchaseAmountService purchaseAmountService) {
        this.purchaseAmountService = purchaseAmountService;
    }

    public int processPurchase() {
        purchaseAmountService.inputMoney(); // 사용자로부터 금액 입력 받기
        int tickeyMoney = purchaseAmountService.getMoney();
        int ticketCount = purchaseAmountService.getLottoTicketCount(tickeyMoney); // 티켓 수 계산
        return ticketCount;
    }
}