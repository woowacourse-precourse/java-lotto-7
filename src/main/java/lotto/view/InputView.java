package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;
import lotto.view.message.InputMessage;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static lotto.view.message.InputMessage.*;
import static lotto.common.ErrorMessage.EMPTY_INPUT;

public class InputView {
    public static String inputMoney() {
        return readAndValidate(ENTER_MONEY);
    }

    public static String inputMainNumber() {
        System.out.println();
        return readAndValidate(ENTER_MAIN_NUMBER);
    }

    public static String inputBonusNumber() {
        System.out.println();
        return readAndValidate(ENTER_BONUS_NUMBER);
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
