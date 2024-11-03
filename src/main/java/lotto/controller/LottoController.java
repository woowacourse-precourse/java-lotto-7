package lotto.controller;

import lotto.domain.*;
import lotto.service.FortuneMachineService;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.OutputService;

public class LottoController {

    LottoService lottoService;
    InputService inputService;
    OutputService outputService;
    FortuneMachineService fortuneMachineService;

    public LottoController(LottoService lottoService, InputService inputService, OutputService outputService, FortuneMachineService fortuneMachineService) {
        this.lottoService = lottoService;
        this.inputService = inputService;
        this.outputService = outputService;
        this.fortuneMachineService = fortuneMachineService;
    }

    public void run() {
        Money money = inputService.getMoney();
        Lottos lottos =fortuneMachineService.getLotto(money);
        outputService.showLotto(lottos);

        WinningNumbers winningNumbers = inputService.getWinningNumbers();
        BonusNumber bonusNumber = inputService.getBonusNumber(winningNumbers);


        Results results = lottoService.calculateResults(winningNumbers, bonusNumber, lottos);
        outputService.showResults(results, money);
    }
}
