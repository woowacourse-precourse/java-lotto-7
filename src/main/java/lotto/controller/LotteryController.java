package lotto.controller;

import lotto.service.LotteryService;

public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController() {
        this.lotteryService = new LotteryService();
    }

    public void startLottery() {
        lotteryService.purchaseLotto();
        lotteryService.setWinningLotto();
        lotteryService.setLottoBonusNumber();
        lotteryService.getLottoWinningStatistics();
    }
}
