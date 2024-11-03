package lotto.controller;

import lotto.service.LottoMachineService;

public class LottoMachine {
    private final LottoMachineService lottoMachineService;

    public LottoMachine() {
        lottoMachineService = new LottoMachineService();
    }

    public void start() {
        lottoMachineService.purchaseLotto();
        lottoMachineService.enterWinningNumbers();
        lottoMachineService.calculateWinnings();
    }
}
