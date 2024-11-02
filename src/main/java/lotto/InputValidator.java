package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.global.ErrorMessage;

public class InputValidator {

    private static final Pattern POSITIVE_INTEGER_REGEX = Pattern.compile("\\d+");
    private static final int MONEY_THRESHOLD = 1000;

    private InputValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validateMoney(String input) {
        if (!POSITIVE_INTEGER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        int money = Integer.parseInt(input);

        if (money == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }

        if (money % MONEY_THRESHOLD != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    public static void validateNumbers(String input){
        if (!input.contains(",")){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS.getMessage());
        }

        String[] choice = input.split(",");
        if (choice.length != 6){
            throw new IllegalArgumentException(ErrorMessage.INVALID_SIZE_OF_NUMBERS.getMessage());
        }

        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(choice));
        if (uniqueNumbers.size() != choice.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS_IN_LOTTO.getMessage());
        }

        Arrays.stream(choice).forEach(InputValidator::validateNumber);
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers){
        validateNumber(input);
        validateDuplicatedBonusNumber(input, winningNumbers);
    }

    private static void validateDuplicatedBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumberInt = Integer.parseInt(input);
        if (winningNumbers.contains(bonusNumberInt)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateNumber(String input) {
        try {
            int number = Integer.parseInt(input);

            // 숫자가 1 이상 45 이하인지 확인
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
