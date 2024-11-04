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
}
