package lotto.helper.valid;

import lotto.config.exception.input.InputException;
import lotto.config.exception.input.InputExceptionMessage;


public class ValidInput {

    private static void checkInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new InputException(InputExceptionMessage.EMPTY_INPUT);
        }
    }

    public static void checkInputPositive(String input) {
        if (Integer.parseInt(input) <= 0)
            throw new InputException(InputExceptionMessage.POSITIVE_INPUT);
    }

    private static void checkInputNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException(InputExceptionMessage.NOT_NUMBER_INPUT);
        }
    }

    private static void checkInputUnit(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new InputException(InputExceptionMessage.INVALID_INPUT_PRICE);
        }
    }

    public static void checkInputDelimiter(String input) {
        if (!input.contains(",")) {
            throw new InputException(InputExceptionMessage.NOT_EXIST_DELIMITER);
        }
    }

    public static void checkInputMoney(String input) {
        checkInputEmpty(input);
        checkInputPositive(input);
        checkInputNumber(input);
        checkInputUnit(input);
    }

    public static void checkInputLottoNumbers(String input) {
        checkInputEmpty(input);
        checkInputDelimiter(input);

        String[] numbers = input.split(",");
        for (String number : numbers) {
            checkInputNumber(number.trim());
        }
    }

    public static void checkInputBonusNumber(String input) {
        checkInputEmpty(input);
        checkInputNumber(input);
    }

}
