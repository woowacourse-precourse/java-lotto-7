package lotto.validator;

import static lotto.constant.LottoConstant.DELIMITER;
import static lotto.constant.LottoConstant.LOTTO_MAX_AMOUNT;
import static lotto.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.ZERO;
import static lotto.exception.LottoErrorCode.BONUS_NUMBER_DUPLICATED;
import static lotto.exception.LottoErrorCode.BONUS_NUMBER_NOT_BLANK;
import static lotto.exception.LottoErrorCode.BONUS_NUMBER_NOT_ONE;
import static lotto.exception.LottoErrorCode.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.exception.LottoErrorCode.LOTTO_NUMBERS_DUPLICATED;
import static lotto.exception.LottoErrorCode.LOTTO_NUMBERS_OUT_OF_RANGE;
import static lotto.exception.LottoErrorCode.LOTTO_PRICE_NOT_BLANK;
import static lotto.exception.LottoErrorCode.LOTTO_PRICE_NOT_IN_1_000;
import static lotto.exception.LottoErrorCode.LOTTO_PRICE_NOT_OVER_1_000_000;
import static lotto.exception.LottoErrorCode.LOTTO_PRICE_NOT_POSITIVE_NUMBER;
import static lotto.exception.LottoErrorCode.LOTTO_PRICE_NOT_UNDER_1_000;
import static lotto.exception.LottoErrorCode.WINNER_LOTTO_NUMBERS_NOT_BLANK;
import static lotto.exception.LottoErrorCode.WINNER_LOTTO_NUMBERS_NOT_SEPARATED_BY_COMMA;
import static lotto.exception.LottoErrorCode.WINNER_LOTTO_NUMBERS_SIZE_NOT_6;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LottoInputValidator { // 사용자 Input 검증

    private static final Pattern POSITIVE_INTEGER = Pattern.compile("^[1-9]\\d*$");
    private static final Pattern BONUS_NUMBER = Pattern.compile("\\d{1,2}");

    public void validateMoney(String money) {
        isMoneyBlank(money);
        isMoneyNotPositiveNumber(money);
        isMoneyUnder_1_000(money);
        isMoneyOver_1_000_000(money);
        isMoneyNotIn_1_000(money);
    }

    public void validateWinnerLottoNumbers(String winnerNumbers) {
        isWinnerNumbersBlank(winnerNumbers);
        isWinnerNumbersContainComma(winnerNumbers);
        isWinnerNumbersSize6(winnerNumbers);

        List<Integer> lottoNumbers = getLottoNumbersFromWinnerLottoNumbers(winnerNumbers);

        isWinnerNumbersOutOfRange(lottoNumbers);
        isWinnerNumbersDuplicated(lottoNumbers);
    }

    public void validateBonusNumber(List<Integer> winnerNumbers, String bonusNumber) {
        isBonusNumBlank(bonusNumber);
        isBonusNumNotOne(bonusNumber);

        int bonus = Integer.parseInt(bonusNumber);
        isBonusNumOutOfRange(bonus);
        isBonusNumDuplicated(winnerNumbers, bonus);
    }

    private static void isBonusNumOutOfRange(int bonus) {
        if (bonus < LOTTO_MIN_NUMBER || bonus > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static void isBonusNumDuplicated(List<Integer> winnerNumbers, int bonus) {
        if (winnerNumbers.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    private static void isBonusNumNotOne(String bonusNumber) {
        if (!BONUS_NUMBER.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_ONE.getMessage());
        }
    }

    private static void isBonusNumBlank(String bonusNumber) {
        if (bonusNumber.isBlank()) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_BLANK.getMessage());
        }
    }

    private static List<Integer> getLottoNumbersFromWinnerLottoNumbers(String winnerNumbers) {
        String[] numbers = winnerNumbers.split(DELIMITER);
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    private static void isWinnerNumbersContainComma(String winnerNumbers) {
        if (!winnerNumbers.contains(DELIMITER)) {
            throw new IllegalArgumentException(WINNER_LOTTO_NUMBERS_NOT_SEPARATED_BY_COMMA.getMessage());
        }
    }

    private static void isWinnerNumbersSize6(String winnerNumbers) {
        if (winnerNumbers.split(DELIMITER).length != LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNER_LOTTO_NUMBERS_SIZE_NOT_6.getMessage());
        }
    }

    private static void isWinnerNumbersBlank(String winnerNumbers) {
        if (winnerNumbers.isBlank()) {
            throw new IllegalArgumentException(WINNER_LOTTO_NUMBERS_NOT_BLANK.getMessage());
        }
    }

    private static void isWinnerNumbersOutOfRange(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    private static void isWinnerNumbersDuplicated(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }

    private static void isMoneyOver_1_000_000(String money) {
        if (Integer.parseInt(money) > LOTTO_MAX_AMOUNT) {
            throw new IllegalArgumentException(LOTTO_PRICE_NOT_OVER_1_000_000.getMessage());
        }
    }

    private static void isMoneyNotIn_1_000(String money) {
        if (Integer.parseInt(money) % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(LOTTO_PRICE_NOT_IN_1_000.getMessage());
        }
    }

    private static void isMoneyUnder_1_000(String money) {
        if (Integer.parseInt(money) < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE_NOT_UNDER_1_000.getMessage());
        }
    }

    private static void isMoneyNotPositiveNumber(String money) {
        if (!POSITIVE_INTEGER.matcher(money).matches()) {
            throw new IllegalArgumentException(LOTTO_PRICE_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    private static void isMoneyBlank(String money) {
        if (money.isBlank()) {
            throw new IllegalArgumentException(LOTTO_PRICE_NOT_BLANK.getMessage());
        }
    }
}
