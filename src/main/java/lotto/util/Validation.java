package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static void validateWinningLength(int length) {
        if (length != 6){
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
        }
    }

    public static void validateNumbersBoundary(List<Integer> winnings){
        for (Integer winning : winnings) {
            validateOneNumBoundary(winning);
        }
    }

    public static void validateInteger(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다.");
        }
    }

    public static void validateOneNumBoundary(int number){
        if (number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1에서 45 사이여야 합니다.");
        }
    }

    public static void validateNoDuplicates(List<Integer> winnings) {
        Set<Integer> uniqueNumbers = new HashSet<>(winnings);
        if (uniqueNumbers.size() != winnings.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호에 중복이 있습니다.");
        }
    }

    public static void validateNoDuplicatesWithBonusNumber(List<Integer> winnings,int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winnings);
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() != winnings.size()+1) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 보너스 번호 사이에 중복이 있습니다.");
        }
    }

}
