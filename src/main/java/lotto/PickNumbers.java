package lotto;

import java.util.List;

public class PickNumbers {

    public PickNumbers() {
        new JackpotNumbers();
        getPickNumbers();
    }

    private void getPickNumbers() {
        try {
            new BonusNumber();
            checkDuplication(JackpotNumbers.jackpotNumbers, BonusNumber.bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPickNumbers();
        }
    }

    private void checkDuplication(List<Integer> jackpot, int bonus) {
        if (jackpot.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복되지 않아야 합니다.");
        }
    }
}
