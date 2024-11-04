package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber = new ArrayList<>();
    private final int bonusNumber;

    WinningNumber(String userWinningNumbers, String userBonusNumber){
        Arrays.stream(userWinningNumbers.split(",")).map(Integer::parseInt).forEach(winningNumber::add);
        this.bonusNumber = Integer.parseInt(userBonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
