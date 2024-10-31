package lotto.controller;

import lotto.service.LotteryService;

public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController() {
        this.lotteryService = new LotteryService();
    }

    public void startLottery() {
        int purchaseAmount = lotteryService.getPurchaseAmount();
        System.out.println("purchaseAmount = " + purchaseAmount);
    }
}
