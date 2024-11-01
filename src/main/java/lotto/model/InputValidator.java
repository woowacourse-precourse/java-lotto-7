package lotto.model;

import static lotto.model.Lotto.*;

public class InputValidator {
    public void validatePurchaseAmount(String input) {
        checkNumberIsPositive(input);
        checkIsDivisibleByLottoPrice(input);
    }

    public int validateBonusNumber(String input, Lotto winningLotto) {
        checkNumberIsPositive(input);
        int bonusNumber = Integer.parseInt(input.trim());
        checkNumberInRange(bonusNumber);
        checkDuplicateWithWinningNumbers(winningLotto, bonusNumber);
        return bonusNumber;
    }

    private void checkNumberIsPositive(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 양수가 아닙니다.");
        }
    }

    private void checkIsDivisibleByLottoPrice(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % LottoService.LOTTO_PRICE !=0) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 로또 가격으로 나누어지지 않습니다.");
        }
    }

    private void checkNumberInRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplicateWithWinningNumbers(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.");
        }
    }
}
