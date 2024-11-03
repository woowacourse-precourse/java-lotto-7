package lotto;

import static lotto.NumberType.LOTTO_MAX_NUMBER;
import static lotto.NumberType.LOTTO_MIN_NUMBER;
import static lotto.NumberType.LOTTO_NUMBER_COUNT;
import static lotto.NumberType.PURCHASE_UNIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    private static final String POSITIVE_NUMBER_PATTERN = "\\d+";
    private static final String INPUT_PURCHASE_AMOUNT_ = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_);
        String value = Console.readLine();
        validateEmpty(value);
        validateNumber(value);
        int amount = Integer.parseInt(value);
        validateUnit(amount);
        return amount;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        validateEmpty(input);
        List<String> values = Utils.splitNumbers(input);
        List<Integer> numbers = Utils.convertNumbers(values);
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        return numbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumber) {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        validateEmpty(input);
        int number = Utils.convertNumber(input);
        validateBonusNumber(number, winningNumber);
        return number;
    }

    private static void validateBonusNumber(int number, List<Integer> winningNumber) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_RANGE);
        }

        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_BONUS);
        }
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_EMPTY_INPUT);
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_NUMBER);
        }
    }

    private static void validateUnit(int amount) {
        if ((amount % PURCHASE_UNIT) != NumberType.ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_UNIT);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_SIZE);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinctedNumbers = new HashSet<>(numbers);

        if (distinctedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_NUMBER);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ExceptionMessage.ERROR_INVALID_RANGE);
            }
        }
    }
}
