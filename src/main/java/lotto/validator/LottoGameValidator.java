package lotto.validator;

import java.util.List;
import lotto.ErrorMessage;
import lotto.policy.LottoPolicy;

public class LottoGameValidator {

    /**
     * 숫자로 구성된 문자열인지 확인
     *
     * @throws IllegalArgumentException 숫자가 아닌 문자가 문자열에 포함되어 있을 때
     */
    public static boolean checkIsNumeric(String str) {
        if (!CommonValidator.isNumeric(str)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_NUMERIC.getMessage());
        }

        return true;
    }

    public static boolean checkIsBlank(String str) {
        if (CommonValidator.isBlank(str)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }

        return false;
    }

    public static boolean checkMoneyValid(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_CAN_NOT_MINUS.getMessage());
        }
        if (!CommonValidator.isDivided(money, LottoPolicy.LOTTO_PRICE)) {
            throw new IllegalArgumentException(ErrorMessage.INSERT_MONEY_NOT_DIVIDED_1000.getMessage());
        }

        return true;
    }

    public static boolean checkWinNumbersValid(List<Integer> winNumbers) {
        if (winNumbers.size() != LottoPolicy.TOTAL_LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WIN_NUMBER_SIZE_MUST_6.getMessage());
        }
        if (CommonValidator.hasDuplicateNumber(winNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WIN_NUMBERS.getMessage());
        }
        for (int winNum : winNumbers) {
            if (!CommonValidator.isBetween(LottoPolicy.MIN_LOTTO_NUM, winNum, LottoPolicy.MAX_LOTTO_NUM)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_BETWEEN_1_AND_45.getMessage());
            }
        }

        return true;
    }

    public static boolean checkBonusValid(int bonus, List<Integer> winNumbers) {
        if (winNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_WIN_NUMBERS.getMessage());
        }
        if (!CommonValidator.isBetween(LottoPolicy.MIN_LOTTO_NUM, bonus, LottoPolicy.MAX_LOTTO_NUM)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_BETWEEN_1_AND_45.getMessage());
        }

        return true;
    }
}
