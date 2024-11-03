package lotto.domain;

import static lotto.utils.Constant.COMMA;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String input) {
        validateBonusNumber(input);
        this.bonusNumber = Integer.parseInt(input);
    }


    // 일단 getter 사용하자..
    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(String input) {
        if (input.contains(COMMA)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 하나의 숫자여야 합니다.");
        }
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상 45 이하의 숫자여야 합니다.");
        }
    }
}
