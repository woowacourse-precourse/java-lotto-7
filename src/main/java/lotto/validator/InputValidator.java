package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class InputValidator {
    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt;
        try {
            purchaseAmountInt = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InputException(LottoConstants.ERROR_NON_INTEGER_AMOUNT);
        }
        if (purchaseAmountInt <= 0 || purchaseAmountInt % 1000 != 0) {
            throw new InputException(LottoConstants.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
        }
        return purchaseAmountInt;
    }

    public static List<Integer> validateWinningNumbers(List<String> winningNumbersInput) {
        // 로또 번호가 정수가 아닌 경우 처리
        List<Integer> winningNumbers;
        try {
            winningNumbers = winningNumbersInput.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InputException(LottoConstants.ERROR_NON_INTEGER_LOTTO_NUMBER);
        }

        // 당첨 번호가 6개가 아닌 경우
        if (winningNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new InputException(LottoConstants.ERROR_INVALID_WINNING_NUMBER_COUNT);
        }

        // 당첨 번호 입력이 1~45 범위를 벗어나는 경우 처리
        if (winningNumbers.stream()
                .anyMatch(num -> num < LottoConstants.LOTTO_NUMBER_MIN || num > LottoConstants.LOTTO_NUMBER_MAX)) {
            throw new InputException(LottoConstants.ERROR_WINNING_NUMBER_OUT_OF_RANGE);
        }

        // 당첨 번호가 중복되는 경우 처리
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new InputException(LottoConstants.ERROR_DUPLICATE_WINNING_NUMBER);
        }

        return winningNumbers;
    }

    public static int validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        // 보너스 번호가 정수가 아닌 경우 처리
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new InputException(LottoConstants.ERROR_NON_INTEGER_BONUS_NUMBER);
        }

        // 보너스 번호가 1~45 범위를 벗어나는 경우 처리
        if (bonusNumber < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new InputException(LottoConstants.ERROR_BONUS_NUMBER_OUT_OF_RANGE);
        }

        // 당첨 번호와 보너스 번호가 중복되는 경우 처리
        if (winningNumbers.contains(bonusNumber)) {
            throw new InputException(LottoConstants.ERROR_DUPLICATE_BONUS_NUMBER);
        }

        return bonusNumber;
    }
}
