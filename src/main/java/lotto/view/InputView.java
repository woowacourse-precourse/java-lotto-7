package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.message.InputMessage;

public class InputView {

    User user;

    public void run() {
        getUserInput();
    }

    private void getUserInput() {
        System.out.println(InputMessage.REQUEST_INPUT_AMOUNT.getMessage());

        String input = Console.readLine();

        user.setMoney(input);
    }

}
