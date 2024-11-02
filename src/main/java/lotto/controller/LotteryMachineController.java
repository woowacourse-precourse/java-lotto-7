package lotto.controller;

import lotto.service.LotteryMachineService;

public class LotteryMachineController {

    private final LotteryMachineService lotteryMachineService;

    public LotteryMachineController(LotteryMachineService lotteryMachineService) {
        this.lotteryMachineService = lotteryMachineService;
    }

    public void run() {
        lotteryMachineService.check();
    }
}
