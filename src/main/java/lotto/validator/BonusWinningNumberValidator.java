package lotto.validator;

public class BonusWinningNumberValidator {
    public int validateBonusWinningNumber(String inputBonusNumber) {
        if (!inputBonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 하나만 입력해 주세요.");
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상의 양수로 입력해 주세요.");
        }
        if (bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }
}
