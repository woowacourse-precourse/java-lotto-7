package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    Messages messages;

    public String getCost() {
        System.out.println(messages.PAYMENT_INPUT_MSG.getMessage());
        return Console.readLine();
    }

    public String getLottoNumbers() {
        System.out.println(messages.LOTTO_INPUT_MSG.getMessage());
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(messages.BONUS_INPUT_MSG.getMessage());
        return Console.readLine();
    }

}
