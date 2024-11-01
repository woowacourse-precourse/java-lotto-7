package lotto.model;

import static lotto.model.Lotto.*;

public class InputValidator {
    public void validatePurchaseAmount(String input) {
        validatePositiveNumber(input);
        validateDivisibleByLottoPrice(input);
    }

    public int validateBonusNumber(String input, Lotto winningLotto) {
        validatePositiveNumber(input);
        int bonusNumber = Integer.parseInt(input.trim());
        validateNumberInRange(bonusNumber);
        validateNoDuplicateWithWinningNumbers(winningLotto, bonusNumber);
        return bonusNumber;
    }

    private void validatePositiveNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 양수가 아닙니다.");
        }
    }

    private void validateDivisibleByLottoPrice(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % LottoTicketMachine.LOTTO_TICKET_PRICE !=0) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 로또 가격으로 나누어지지 않습니다.");
        }
    }

    private void validateNumberInRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNoDuplicateWithWinningNumbers(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.");
        }
    }
}
