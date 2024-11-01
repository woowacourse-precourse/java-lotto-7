package lotto;

import java.util.List;

public class Winning {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    public Winning(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개입니다.");
        }
    }
}
