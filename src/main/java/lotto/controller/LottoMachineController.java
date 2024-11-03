package lotto.controller;

import lotto.domain.User;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.WinningService;

public class LottoMachineController {

    private final User user = new User();

    InputService inputService = new InputService(user);
    LottoService lottoService = new LottoService(user);
    WinningService winningService = new WinningService();

    public void run() {
        inputService.run();
        lottoService.run();
        winningService.run();
    }
}
