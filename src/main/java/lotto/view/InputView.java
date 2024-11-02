package lotto.view;

import static lotto.message.LottoMessage.DISPLAY_LOTTO_COUNT;

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
        displayLottoPurchaseAmount(user);
    }

    public void displayLottoPurchaseAmount(User user) {
        System.out.printf(DISPLAY_LOTTO_COUNT.getMessage(), user.getNumOfLottos());
    }
}
