package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;
import lotto.view.message.InputMessage;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static lotto.view.message.InputMessage.*;
import static lotto.common.ErrorMessage.EMPTY_INPUT;

public class InputView {
    public static String inputMoney() {
        return handleInput(ENTER_MONEY);
    }

    public static String inputMainNumber() {
        System.lineSeparator();
        return handleInput(ENTER_MAIN_NUMBER);
    }

    public static String inputBonusNumber() {
        System.lineSeparator();
        return handleInput(ENTER_BONUS_NUMBER);
    }

    private static String handleInput(InputMessage message) {
        while (true) { // TODO: 반복 재귀 이외 방법으로 구현할 수 있는지?
            try {
                return readAndValidate(message);
            } catch (IllegalArgumentException e) { // TODO: 적절한 Exception로 수정
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readAndValidate(InputMessage message) {
        System.out.println(message.getMessage());
        String inputValue = Console.readLine();
        validate(inputValue);
        return inputValue;
    }

    private static void validate(String inputValue) throws IllegalArgumentException { // TODO: 적절한 Exception로 수정
        Validator.checkEmpty(inputValue);
    }
}
