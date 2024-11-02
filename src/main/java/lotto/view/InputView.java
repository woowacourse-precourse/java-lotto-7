package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.InteractionMessage;

import static lotto.view.message.InteractionMessage.ENTER_MONEY;
import static lotto.view.message.InteractionMessage.ENTER_WINNING_NUMBER;
import static lotto.view.message.InteractionMessage.ENTER_BONUS_NUMBER;
import static lotto.common.ErrorMessage.EMPTY_INPUT;

public class InputView {
    public static String inputMoney() {
        return handleInput(ENTER_MONEY);
    }

    public static String inputWinningNumber() {
        return handleInput(ENTER_WINNING_NUMBER);
    }

    public static String inputBonusNumber() {
        return handleInput(ENTER_BONUS_NUMBER);
    }

    private static String handleInput(InteractionMessage message) {
        while (true) {
            try {
                return readAndPrint(message);
            } catch (IllegalArgumentException error) { // TODO: 적절한 Exception로 수정
                System.out.println(error.getMessage());
            }
        }
    }

    private static String readAndPrint(InteractionMessage message) {
        System.out.println(message.getMessage());
        String inputValue = Console.readLine();
        return inputValue;
    }
}
