package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    public static final String INVALID_PURCHASE_AMOUNT_TYPE_ERROR = "[ERROR] 구입 금액은 숫자로 입력해야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_DIVISIBILITY_ERROR = "[ERROR] 구입 금액은 "
            + LottoConstant.LOTTO_PRICE + "원 단위로 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 "
            + LottoConstant.LOTTO_NUMBER_COUNT + "개여야 합니다.";
    public static final String INVALID_WINNING_NUMBERS_TYPE_ERROR = "[ERROR] 당첨 번호는 숫자로 입력해야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER_ERROR = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";
    public static final String INVALID_WINNING_NUMBER_RANGE_ERROR = "[ERROR] 당첨 번호는 "
            + LottoConstant.LOTTO_MIN_NUMBER + "부터 " + LottoConstant.LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_COUNT_ERROR = "[ERROR] 당첨 번호는 "
            + LottoConstant.LOTTO_NUMBER_COUNT + "개여야 합니다.";
    public static final String INVALID_BONUS_NUMBER_TYPE_ERROR = "[ERROR] 보너스 번호는 숫자로 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 번호는 "
            + LottoConstant.LOTTO_MIN_NUMBER + "부터 " + LottoConstant.LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String DUPLICATE_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";

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
        if (purchaseAmount % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_DIVISIBILITY_ERROR);
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT_ERROR);
        }
        validateDuplicateLottoNumbers(numbers);
    }

    private static void validateDuplicateLottoNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }

    public static List<Integer> validateAndParseWinningNumbers(String input) {
        List<Integer> numbers = parseWinningNumbers(input);
        validateWinningNumberCount(numbers);
        validateDuplicate(numbers);
        validateWinningNumberRange(numbers);
        return numbers;
    }

    private static List<Integer> parseWinningNumbers(String input) {
        try {
            return List.of(input.split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_TYPE_ERROR);
        }
    }

    private static void validateWinningNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_COUNT_ERROR);
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER_ERROR);
        }
    }

    private static void validateWinningNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LottoConstant.LOTTO_MIN_NUMBER
                || number > LottoConstant.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE_ERROR);
        }
    }

    public static int validateAndParseBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = parseBonusNumber(input);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_TYPE_ERROR);
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_MIN_NUMBER || bonusNumber > LottoConstant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE_ERROR);
        }
    }

    private static void validateBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }
}
