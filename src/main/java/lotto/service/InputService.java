package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.message.InputMessage;
import lotto.validate.InputValidate;

public class InputService {

    public void getUserInput(User user) {
        while (true) {
            System.out.println(InputMessage.REQUEST_INPUT_AMOUNT.getMessage());

            String input = Console.readLine();
            if (!InputValidate.run(input)) continue;

            user.setMoney(input);
            break;
        }

        int lottoPurchaseAmount = getLottoPurchaseAmount(user);
        setLottoPurchaseAmount(lottoPurchaseAmount, user);
    }

    public int getLottoPurchaseAmount(User user) {
        return user.getMoney() / 1000;
    }

    public void setLottoPurchaseAmount(int purchaseAmount, User user) {
        user.setNumOfLottos(purchaseAmount);
    }
}
