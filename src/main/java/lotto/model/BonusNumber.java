package lotto.model;

import java.util.List;

public class BonusNumber {
    private int bonusNumber;

    private BonusNumber(String userInputNumber, List<Integer> winningNumbers) {
        int number = convertToType(userInputNumber);
        validate(number, winningNumbers);
        this.bonusNumber = number;
    }

    public static BonusNumber from(String userInputNumber, List<Integer> winningNumbers) {
        return new BonusNumber(userInputNumber, winningNumbers);
    }

    private int convertToType(String userInputNumber) {
        try {
            return Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌값은 입력할 수 없습니다.");
        }
    }

    private void validate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복되는 숫자가 존재합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자만 입력이 가능합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
