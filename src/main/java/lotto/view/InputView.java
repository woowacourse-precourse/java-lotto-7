package lotto.view;

import lotto.domain.User;
import lotto.service.InputService;

public class InputView {

    private final User user;
    private final InputService inputService = new InputService();

    public InputView(User user) {
        this.user = user;
    }

    public void run() {
        inputService.getUserInput(user);
    }


}
