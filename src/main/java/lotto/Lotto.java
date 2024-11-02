package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public int countWinningNumber(List<Integer> winningNumbers){
        int count = 0;

        for (int idx = 0; idx < numbers.size(); idx++) {
            if(winningNumbers.contains(numbers.get(idx))){
                count++;
            }
        }

        return count;
    }

    public boolean checkBonusNumberMatch(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

}
