package lotto.validate;

import lotto.domain.Lotto;
import lotto.enums.ErrorMessage;

import java.util.List;

public class LottoValidator {
    private final static int LOTTO_PRICE = 1000;
    private final static String IS_STRING_INTEGER = "\\d+";

    public static void validatePurchaseAmountPositive(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_LOTTO_PRICE_ERROR.getMessage());
        }
    }

    public static void validatePurchaseAmountUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LOTTO_PRICE_ERROR.getMessage());
        }
    }

    public static void validateNumbersInteger(List<String> lottoNumbers) {
        lottoNumbers.forEach(LottoValidator::validateInteger);
    }

    public static void validateLottoNumbersRange(List<String> lottoNumbers) {
        lottoNumbers.stream()
                .map(Integer::parseInt)
                .forEach(LottoValidator::validateLottoNumberRange);
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_ERROR.getMessage());
        }
    }

    public static void validateNumbersDuplication(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateInteger(String inputString) {
        if (!inputString.matches(IS_STRING_INTEGER)) {
            throw new IllegalArgumentException(ErrorMessage.CHARACTER_INPUT_ERROR.getMessage());
        }
    }

    public static void validateLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    public static void validateLottoBonusNumberDuplication(Lotto winningNumbers, int bonusNumber) {
        for (Integer lotto : winningNumbers.getNumbers()) {
            if (lotto == bonusNumber) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATION_LOTTO_NUMBER_ERROR.getMessage());
            }
        }
    }
}
