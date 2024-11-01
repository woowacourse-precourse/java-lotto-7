package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    // 구매 금액
    public int validatePurchaseAmount (String purchaseAmountInput) {
        int purchaseAmount = validateInputIsDigit(purchaseAmountInput, "[ERROR] 구매 금액은 숫자만 올 수 있습니다.");
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로만 입력할 수 있습니다.");
        }
        return purchaseAmount;
    }

    // 당첨 번호
    public List<Integer> validateWinningNumbers (String winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbersInput.split(",")) {
            winningNumbers.add(validateInputIsDigit(winningNumber, "[ERROR] 로또 번호는 숫자만 올 수 있습니다."));
        }
        for (int winningNumber : winningNumbers) {
            validateNumberRange(winningNumber, "[ERROR] 로또 번호는 1~45 사이에 존재해야 합니다.");
        }
        validateDuplicateWinningNumbers(winningNumbers);
        return winningNumbers;
    }
    public void validateDuplicateWinningNumbers (List<Integer> winningNumbersInput) {
        Set<Integer> winningNumbers = new HashSet<>(winningNumbersInput);
        if (winningNumbers.size() != winningNumbersInput.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // 보너스 번호
    public int validateBonusNumber (String bonusNumberInput, List<Integer> winningNumbers) {
        int bonusNumber = validateInputIsDigit(bonusNumberInput, "[ERROR] 보너스 번호는 숫자만 올 수 있습니다.");
        validateNumberRange(bonusNumber, "[ERROR] 보너스 번호는 1~45 사이에 존재해야 합니다.");
        validateDuplicateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }
    public void validateDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (bonusNumber == winningNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        }
    }

    // 공통 사용 메서드
    public int validateInputIsDigit (String inputNumber, String errorMessage) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    public void validateNumberRange(int bonusNumber, String errorMessage) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
