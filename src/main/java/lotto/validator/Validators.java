package lotto.validator;

import lotto.domain.Lotto;

public class Validators {

    public void validatePurchaseAmountUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
        }
    }

    public void validateNumericInput(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public void validateSplitNumericInput(String inputNumbers) {
        try {
            String[] parts = inputNumbers.split(",");
            for (String part : parts) {
                Integer.parseInt(part);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public void validateNumberRange(int number) {
        if (!(number > 0 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 번호는 0~45사이의 숫자여야 합니다.");
        }
    }

    public void validateBonusNotInWinningNumbers(Lotto lotto, int bonusNumber) {
        if (lotto.matchNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 일치합니다.");
        }
    }
}
