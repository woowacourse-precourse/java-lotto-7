package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ViewMessage;
import lotto.utils.Converter;
import lotto.validator.InputValidator;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class InputView {

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        return readLine(
                ViewMessage.INPUT_BUY_MONEY_MESSAGE.getMessage(),
                Converter::trimInput,
                InputValidator::validatePurchaseAmount,
                Converter::convertToNumber
        );
    }

    public static List<Integer> inputWinNumbers() {
        return readLine(
                ViewMessage.INPUT_WIN_NUMBERS_MESSAGE.getMessage(),
                Converter::trimInput,
                InputValidator::validateWinNumbers,
                Converter::convertNumbers
        );
    }

    public static int inputBonusNumber() {
        return readLine(
                ViewMessage.INPUT_BONUS_NUMBER_MESSAGE.getMessage(),
                Converter::trimInput,
                InputValidator::validateBonusNumber,
                Converter::convertToNumber
        );
    }

    private static <T> T readLine(
            String message,
            Function<String, String> preProcessor,
            Consumer<String> validator,
            Function<String, T> converter
    ) {
        System.out.println(message);
        String input = Console.readLine();
        input = preProcessor.apply(input);
        validator.accept(input);
        return converter.apply(input);
    }
}
