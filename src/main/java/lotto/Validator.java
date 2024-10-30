package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Validator {
    public static void validateInput(List<Integer> winningNumber){
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumber);
        if (uniqueNumbers.size() != winningNumber.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
    public static void validateInput(String bonusNumber,List<Integer> winningNumber){
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.", e);
        }

        int bonus = Integer.parseInt(bonusNumber);
        checkBonusNumberDuplication(bonus,winningNumber);
    }

    private static void checkBonusNumberDuplication(int bonus,List<Integer> winningNumber) {
        if (winningNumber.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다");
        }
    }
}
