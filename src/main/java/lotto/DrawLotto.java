package lotto;

import java.util.ArrayList;
import java.util.List;

public class DrawLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public DrawLotto(String winningNumber, String bonusNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : winningNumber.split(",")) {
            numbers.add(Integer.parseInt(s));
        }
        this.winningNumbers = numbers;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
