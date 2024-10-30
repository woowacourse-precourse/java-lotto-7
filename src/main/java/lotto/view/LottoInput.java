package lotto.view;

import static lotto.config.ErrorMessage.INPUT_MONEY_ERROR;
import static lotto.config.LottoMessage.INPUT_MONEY;

import camp.nextstep.edu.missionutils.Console;

public class LottoInput {

    private LottoInput() {
    }

    public static int inputMoney() {
        printInputMoney();
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR.getMessage());
        }
    }

    private static void printInputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
    }
}
