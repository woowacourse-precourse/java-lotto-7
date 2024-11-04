package lotto.view;

import static lotto.message.InputMessage.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.message.InputMessage.PURCHASE_INFORMATION_MESSAGE;
import static lotto.message.InputMessage.WINNING_NUMBER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getPayment() {
        System.out.println(PURCHASE_INFORMATION_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}