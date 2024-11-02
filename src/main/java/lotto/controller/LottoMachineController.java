package lotto.controller;

import lotto.domain.User;
import lotto.service.InputService;

public class LottoMachineController {

    private final User user = new User();

    InputService inputService = new InputService(user);

    public void run() {
        inputService.run();
    }
}
