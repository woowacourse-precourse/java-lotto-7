package lotto.controller;

import lotto.domain.User;
import lotto.service.InputService;
import lotto.service.LottoService;

public class LottoMachineController {

    private final User user = new User();

    InputService inputService = new InputService(user);
    LottoService lottoService = new LottoService(user);

    public void run() {
        inputService.run();
        lottoService.run();
    }
}
