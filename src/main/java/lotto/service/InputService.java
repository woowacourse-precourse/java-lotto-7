package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.message.InputMessage;
import lotto.validate.InputValidate;
import lotto.view.InputView;

public class InputService {

    private final User user;

    public InputService(User user) {
        this.user = user;
    }

    public void run() {
        getUserInput(user);
        InputView.displayLottoPurchaseAmount(user);
    }

    public void getUserInput(User user) {
        while (true) {
            System.out.println(InputMessage.REQUEST_INPUT_AMOUNT.getMessage());

            String input = Console.readLine();
            if (!InputValidate.run(input)) continue;

            user.setMoney(input);
            break;
        }

        setLottoPurchaseAmount(user);
    }

    public static int getLottoPurchaseAmount(User user) {
        setLottoPurchaseAmount(user);
        return user.getNumOfLottos();
    }

    public static void setLottoPurchaseAmount(User user) {
        user.setNumOfLottos();
    }
}
