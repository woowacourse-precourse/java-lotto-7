package lotto.validator;

import static lotto.util.LottoUtils.validateNumberRange;

public class WinningNumberValidator implements Validator<String> {

    private static final String WINNING_NUMBERS_DELIMITER = ",";
    private static final Integer LOTTO_NUMBER_COUNT = 6;

    @Override
    public void validate(String winningNumber) {
        String[] winningNumbers = winningNumber.split(WINNING_NUMBERS_DELIMITER);
        validateNumberCount(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
    }

    private void validateNumberCount(String[] winningNumbers) {
        if (winningNumbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException("[ERROR] 로또 번호는 중복되지 않도록 1 ~ 45 사이의 6개의 정수를 입력해주세요");
        }
    }

    private void validateWinningNumbersRange(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            validateNumberRange(Integer.parseInt(winningNumber));
        }
    }
}
