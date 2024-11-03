package lotto.view;

import static lotto.message.InputMessage.PURCHASE_INFORMATION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getPayment() {
        System.out.println(PURCHASE_INFORMATION_MESSAGE.getMessage());
        return Console.readLine();
    }
}
