package exception;

import java.util.Collections;
import java.util.List;

public class Handler {
    public static int getMoney(io.Input input) {
        String inputString = input.getInput();
        int money = 1;

        try {
            money = Integer.parseInt(inputString);
        } catch (IllegalArgumentException ex) {
            //get Lotto Number에서 처리
        }
        return money;
    }

    protected static boolean moneyIsValid(int money) {
        if (money % lotto.Lotto.Price.PRICE != 0) {
            Message message = new Message(Integer.toString(money));
            String exceptionMessage = message.getMessage(Message.INVALID_MONEY);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return true;
    }

    public static int getLottoNumber() {
        int money = 0;
        boolean validity = false;

        while (!validity) {
            io.Input input = new io.Input();
            String inputString = input.getInput();
            try {
                money = exception.Handler.getMoney(input);
                validity = moneyIsValid(money);
            } catch (IllegalArgumentException ex) {
                exception.Handler.handleException(inputString, Message.INVALID_MONEY);
            }
        }
        return money / lotto.Lotto.Price.PRICE;
    }

    public static void handleException(String inputString, String exceptionMessage) {
        exception.Message message = new exception.Message(inputString);
        String printMessage = message.getMessage(exceptionMessage);
        io.Print.print(printMessage);
    }

    public static boolean isValid(List<Integer> numbers) {
        try {
            exception.Handler.validateNumbers(numbers);
        } catch (IllegalArgumentException ex) {
            exception.Handler.handleException(numbers.toString(), Message.INVALID_CHOICE);
            return false;
        }
        try {
            int number = Handler.findDuplicateNumber(numbers);
            raiseException(number);
        } catch (IllegalArgumentException ex) {
            exception.Handler.handleException(numbers.toString(), Message.DUPLICATE_NUMBER);
            return false;
        }
        try {
            int number = Handler.findInvalidNumber(numbers);
            raiseException(number);
        } catch (IllegalArgumentException ex) {
            exception.Handler.handleException(numbers.toString(), Message.INVALID_RANGE);
            return false;
        }
        return true;
    }

    public static void raiseException(int input) {
        if (input != -1) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbers(List<Integer> numbers) { // 원본은 Lotto.validate
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static int findDuplicateNumber(List<Integer> numbers) {
        int duplicate = -1;
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) != 1) {
                return number;
            }
        }
        return duplicate;
    }

    public static int findInvalidNumber(List<Integer> numbers) {
        int invalid = -1;
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return number;
            }
        }
        return invalid;
    }

}
