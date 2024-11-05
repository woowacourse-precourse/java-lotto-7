package lotto.domain.util;

import java.util.List;

public class AddBonusNumber {

    private AddBonusNumber() {}

    public static List<Integer> add(List<Integer> winningNumbers, String input) {
        int bonusNumber = Integer.parseInt(input);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }
}
