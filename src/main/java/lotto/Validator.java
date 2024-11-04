package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String COMMON_ERROR_MESSAGE = "[ERROR] ";
    private static final String NUMBER_ERROR_MESSAGE = "입력은 숫자 형태여야 합니다.";
    private static final String POSITIVE_RANGE_ERROR_MESSAGE = "양수 범위 내에서 입력 가능합니다.";
    private static final String LOTTERY_RANGE_ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 값이어야 합니다";
    private static final String AMOUNT_UNIT_ERROR_MESSAGE = "입력은 1000단위어야 합니다.";
    private static final String LOTTERY_NUMBER_COUNT_ERROR_MESSAGE = "로또 번호는 총 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력은 비어있을 수 없습니다.";

    private static final String WINNING_NUMBER_OPERATOR = ",";
    public static final int PURCHASE_AMOUNT_STANDARD = 1000;

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
        if (num < LottoConstants.LOTTERY_NUM_RANGE_FIRST || LottoConstants.LOTTERY_NUM_RANGE_LAST < num) {
            throw new IllegalArgumentException(LOTTERY_RANGE_ERROR_MESSAGE);
        }
    }

    private void checkIsInputEmpty(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    private Set<Integer> checkDuplicatesAndSize(String[] splitInputs) {
        Set<Integer> winningDigits = new HashSet<>();

        for (String splitInput : splitInputs) {
            Integer parseInt = Integer.parseInt(splitInput);
            if (winningDigits.contains(parseInt)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
            }
            winningDigits.add(parseInt);
        }
        if (winningDigits.size() != LottoConstants.LOTTERY_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTERY_NUMBER_COUNT_ERROR_MESSAGE);
        }
        return winningDigits;
    }

    public void validatePurchaseAmount(String purchaseInput) {
        try {
            checkIsInputEmpty(purchaseInput);
            checkIsNumber(purchaseInput);
            int num = Integer.parseInt(purchaseInput);
            checkIsPositiveNumber(num);
            if (num % PURCHASE_AMOUNT_STANDARD != 0) {
                throw new IllegalArgumentException(AMOUNT_UNIT_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE +  e.getMessage());
        }
    }

    public void validateWinningNumbers(String winningNumbersInput) {
        try {
            checkIsInputEmpty(winningNumbersInput);
            String[] splitInputs = winningNumbersInput.split(WINNING_NUMBER_OPERATOR);
            Arrays.stream(splitInputs).forEach(this::checkIsNumber);

            Set<Integer> winningDigits = checkDuplicatesAndSize(splitInputs);
            winningDigits.forEach(winningDigit -> {
                checkIsPositiveNumber(winningDigit);
                checkIsLotteryRange(winningDigit);
            });

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE +  e.getMessage());
        }
    }

    public void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        try {
            checkIsInputEmpty(bonusNumberInput);
            checkIsNumber(bonusNumberInput);
            int num = Integer.parseInt(bonusNumberInput);
            checkIsPositiveNumber(num);
            checkIsLotteryRange(num);
            if (winningNumbers.contains(num)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE +  e.getMessage());
        }
    }
}
