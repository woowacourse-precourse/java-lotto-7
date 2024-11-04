package lotto.controller;

import lotto.service.LotteryService;

public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController() {
        this.lotteryService = new LotteryService();
    }

    public void startLottery() {
        // 로또를 구매한다.
        lotteryService.purchaseLotto();
        lotteryService.setWinningLotto();
        lotteryService.getLottoBonusNumber();
        lotteryService.getLottoWinningStatistics();
    }
}
