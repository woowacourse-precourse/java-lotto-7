package lotto.domain.util;

import java.util.List;

public final class AddBonusNumber {

    public static List<Integer> create(List<Integer> winningNumbers, String input) {
        int bonusNumber = Integer.parseInt(input);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }
}
