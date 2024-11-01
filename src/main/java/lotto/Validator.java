package lotto;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final String COMMON_ERROR_MESSAGE = "[ERROR] ";
    private static final String NUMBER_ERROR_MESSAGE = "입력은 숫자 형태여야 합니다.";
    private static final String POSITIVE_RANGE_ERROR_MESSAGE = "양수 범위 내에서 입력 가능합니다.";
    private static final String LOTTERY_RANGE_ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 값이어야 합니다";

    private static final int LOTTERY_NUM_RANGE_FIRST = 1;
    private static final int LOTTERY_NUM_RANGE_LAST = 45;

    private static final String WINNING_NUMBER_OPERATOR = ",";
    private static final String DUPLICATE_NUMBER_ERROR = "중복된 숫자는 입력할 수 없습니다.";

    private void checkIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private void checkIsPositiveNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(POSITIVE_RANGE_ERROR_MESSAGE);
        }
    }

    private void checkIsLotteryRange(int num) {
        if (num < LOTTERY_NUM_RANGE_FIRST || LOTTERY_NUM_RANGE_LAST < num) {
            throw new IllegalArgumentException(LOTTERY_RANGE_ERROR_MESSAGE);
        }
    }

    public void validatePurchaseAmount(String purchaseInput) {
        try {
            checkIsNumber(purchaseInput);
            int num = Integer.parseInt(purchaseInput);
            checkIsPositiveNumber(num);
            checkIsLotteryRange(num);
        } catch (IllegalArgumentException e) {
            System.out.println(COMMON_ERROR_MESSAGE + e.getMessage());
        }
    }

    public void validateWinningNumbers(String winningNumbersInput) {
        String[] splitInputs = winningNumbersInput.split(WINNING_NUMBER_OPERATOR);
        try {
            Arrays.stream(splitInputs).forEach(this::checkIsNumber);

            List<Integer> winningDigits = Arrays.stream(splitInputs)
                .map(Integer::parseInt).toList();

            for (Integer w : winningDigits) {
                checkIsPositiveNumber(w);
                checkIsLotteryRange(w);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(COMMON_ERROR_MESSAGE + e.getMessage());
        }
    }

    public void validateBonusNumber(String bonusNumberInput) {
        try {
            checkIsNumber(bonusNumberInput);
            int num = Integer.parseInt(bonusNumberInput);
            checkIsPositiveNumber(num);
            checkIsLotteryRange(num);
        } catch (IllegalArgumentException e) {
            System.out.println(COMMON_ERROR_MESSAGE + e.getMessage());
        }
    }
}
