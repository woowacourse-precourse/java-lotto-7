package lotto.winning.validator;

import static lotto.common.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.common.constant.LottoConstant.LOTTO_NUMBER_LIMIT;
import static lotto.common.constant.LottoConstant.LOTTO_START_NUMBER;

import java.util.List;

public class ValidatorOfWinningNumber {
    private static ValidatorOfWinningNumber validator;

    private ValidatorOfWinningNumber() {}

    public static ValidatorOfWinningNumber getValidator() {
        if (validator == null) {
            validator = new ValidatorOfWinningNumber();
            return validator;
        }
        return validator;
    }

    public void validateCastingToNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력하세요.");
        }
    }

    public void validateInRange(int number) {
        boolean isInRange = (LOTTO_START_NUMBER <= number) && (number <= LOTTO_END_NUMBER);
        if (!isInRange) {
            throw new IllegalArgumentException("[ERROR] 1 - 45 사이의 숫자만 입력하세요.");
        }
    }

    public void validateDegenerate(List<Integer> winningNumbers, int number) {
        if (winningNumbers == null) {
            return;
        }

        boolean isDegenerated = winningNumbers.contains(number);
        if (isDegenerated) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    public void validateLottoLimit(List<Integer> winningNumbers) {
        if (!(winningNumbers.size() == LOTTO_NUMBER_LIMIT)) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력하세요.");
        }
    }
}
