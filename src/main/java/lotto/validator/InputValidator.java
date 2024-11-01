package lotto.validator;

import java.util.HashSet;
import java.util.List;
import lotto.utils.InputUtils;

public class InputValidator {

    private static final int UNIT = 1000;
    private static final int REMAINDER = 0;
    private static final int SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private static final String INVALID_UNIT_ERROR = "[ERROR] 금액은 1000원 단위로 입력해주세요.";
    private static final String NUMBER_SIZE_ERROR = "[ERROR] 6개의 숫자를 입력해주세요.";
    private static final String OUT_OF_RANGE_ERROR = "[ERROR] 1에서 45 사이의 숫자로 입력해주세요.";
    private static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 중복되지 않는 숫자로 입력해주세요.";

    public static void validateAmount(String amount) {
        int parsedAmount = InputUtils.parseInt(amount);
        validateUnit(parsedAmount);
    }

    public static void validateLottoNumbers(List<String> lottoNumbers) {
        List<Integer> parsedNumbers = InputUtils.parseIntList(lottoNumbers);
        validateLength(parsedNumbers);
        validateRange(parsedNumbers);
        validateDuplication(parsedNumbers);
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> lottoNumbers) {
        int parsedBonus = InputUtils.parseInt(bonusNumber);
        validateRange(List.of(parsedBonus));
        validateBonusDuplication(parsedBonus, lottoNumbers);
    }

    private static void validateUnit(int parseAmount) {
        if ((parseAmount % UNIT) != REMAINDER) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR);
        }
    }

    private static void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MIN_VALUE || num > MAX_VALUE)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private static void validateBonusDuplication(int parseBonus, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(parseBonus)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

}
