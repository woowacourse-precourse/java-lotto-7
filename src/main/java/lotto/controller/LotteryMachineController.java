package lotto.controller;

import lotto.service.LotteryMachineService;
import lotto.view.OutputView;

public class LotteryMachineController {

    private final OutputView outputView;
    private final LotteryMachineService lotteryMachineService;

    public LotteryMachineController(OutputView outputView, LotteryMachineService lotteryMachineService) {
        this.outputView = outputView;
        this.lotteryMachineService = lotteryMachineService;
    }

    public void run() {
        lotteryMachineService.check();

        StringBuilder sb = new StringBuilder();
        lotteryMachineService.getStatistic(sb);
        outputView.print(sb.toString());

        sb = new StringBuilder();
        lotteryMachineService.getProfitRate(sb);
        outputView.print(sb.toString());
    }
}
