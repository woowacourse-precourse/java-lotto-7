package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utils.ErrorMessage;
import lotto.utils.Message;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println(Message.PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        int amount = parseAmount(input);
        validatePurchaseAmount(amount);
        return amount;
    }

    public static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER);
        }
    }

    static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.PURCHASE_AMOUNT_INVALID);
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    public static Lotto inputWinningLotto() {
        System.out.println(Message.WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        List<Integer> numbers = parseNumbers(input);
        return new Lotto(numbers);
    }

    public static int inputBonusNumber(Lotto winningLotto) {
        System.out.println(Message.BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        int bonusNumber = parseBonusNumber(input);
        validateBonusNumber(bonusNumber, winningLotto);
        return bonusNumber;
    }

    public static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.BONUS_NUMBER_NOT_NUMBER);
        }
    }

    static void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE);
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.BONUS_NUMBER_DUPLICATED);
        }
    }

    static List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.WINNING_NUMBER_COUNT_INVALID);
        }
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = parseNumber(token.trim());
            validateNumber(number, numbers);
            numbers.add(number);
        }
        return numbers;
    }

    public static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_NOT_NUMBER);
        }
    }

    public static void validateNumber(int number, List<Integer> numbers) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
        }
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_DUPLICATED);
        }
    }
}
