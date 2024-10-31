package lotto;

import java.util.List;

public class WinnerNumbers {
    public WinnerNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }
}
