package lotto.io;

import java.util.Arrays;
import java.util.List;

public abstract class Validator {
    private static final String NOT_POSITIVE_NUMBER_ERROR = "[ERROR] 양수를 입력해 주세요";
    private static final String PRICE_NOT_DIVIDED_BY_1000_ERROR = "[ERROR] 로또 구입은 1,000원 단위로 구입해야 합니다.";
    private static final String WINNING_NUMBER_FORMAT_ERROR = "[ERROR] 당첨 번호는 공백을 포함하지 않고 쉼표로 구분된 6개의 숫자여야 합니다.";
    private static final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 당첨 번호는 1~45숫자만 가능합니다.";
    private static final String WINNING_NUMBER_DUPLICATE_ERROR = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 번호는 1~45숫자만 가능합니다.";
    private static final String BONUS_NUMBER_DUPLICATE_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static void validatePrice(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_NOT_DIVIDED_BY_1000_ERROR);
        }
    }

    public static void validateWinningNumbersFormat(String input) {
        try {
            Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR);
        }
    }

    public static void validateWinningNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR);
        }
        for (int number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException(WINNING_NUMBER_RANGE_ERROR);
            }
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR);
        }
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }
}
