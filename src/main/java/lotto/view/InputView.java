package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.message.InputMessage;
import lotto.validate.InputValidate;

public class InputView {

    private final User user;

    public InputView(User user) {
        this.user = user;
    }

    public void run() {
        getUserInput();
    }

    private void getUserInput() {
        while (true) {
            System.out.println(InputMessage.REQUEST_INPUT_AMOUNT.getMessage());

            String input = Console.readLine();
            if (!InputValidate.run(input)) continue;

            user.setMoney(input);
            break;
        }
    }

}
