package lotto.model;

import java.util.List;

public class BonusNumber {
    private int bonusNumber;

    private BonusNumber(String userInputNumber, List<Integer> winningNumbers) {
        int number = convertToType(userInputNumber);
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


    public int getBonusNumber() {
        return bonusNumber;
    }

}
