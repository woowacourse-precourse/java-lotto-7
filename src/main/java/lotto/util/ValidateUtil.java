package lotto.util;

import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;

public class ValidateUtil {
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final Integer LOTTO_PRICE = 1000;

    public void validatePurchaseAmount(final String input) {
        validateNumber(input);
        validateAmount(input);
    }

    public void validateWinningNumbers(final String input) {
        final List<String> winningNumbers = Arrays.asList(input.split(WINNING_NUMBER_DELIMITER));
        winningNumbers.forEach(this::validateNumber);
    }

    public void validateBonusNumber(final String input, final List<Integer> winningNumbers) {
        validateNumber(input);
        validateDuplicate(input, winningNumbers);
    }

    private void validateNumber(final String input) {
        if (!input.matches(NUMBER_PATTERN)) // 정수로 이루어진 문자열인지 검증 [0-9]+
            throw new IllegalArgumentException(LottoException.NUMBER_FORMAT_NOT_VALID.getMessage());
    }

    public void validateAmount(final String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) // 1,000원 단위로 나누어 떨어지지 않을 경우
            throw new IllegalArgumentException(LottoException.PURCHASE_AMOUNT_NOT_VALID.getMessage());
    }

    public void validateDuplicate(final String bonusNumberInput, final List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumberInput))) // 입력 받은 보너스 번호가 당첨 번호와 중복될 경우
            throw new IllegalArgumentException(LottoException.BONUS_NUMBER_DUPLICATED.getMessage());
    }

}
