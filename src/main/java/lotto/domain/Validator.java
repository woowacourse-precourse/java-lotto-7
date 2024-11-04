package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    public static final String INVALID_PURCHASE_AMOUNT_TYPE_ERROR = "[ERROR] 구입 금액은 숫자로 입력해야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_DIVISIBILITY_ERROR = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_WINNING_NUMBERS_TYPE_ERROR = "[ERROR] 당첨 번호는 숫자로 입력해야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER_ERROR = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";


    public static int validateAndParsePurchaseAmount(String input) {
        int purchaseAmount = parsePurchaseAmount(input);
        validateDivisibility(purchaseAmount);
        return purchaseAmount;
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_TYPE_ERROR);
        }
    }

    private static void validateDivisibility(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_DIVISIBILITY_ERROR);
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    public static List<Integer> validateAndParseWinningNumbers(String input) {
        List<Integer> numbers;
        try {
            numbers = List.of(input.split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_TYPE_ERROR);
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER_ERROR);
        }
        return numbers;
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
