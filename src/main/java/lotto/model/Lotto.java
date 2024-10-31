package lotto.model;

import lotto.utils.Utils;

import java.util.List;

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

    public int getWinningCount(List<Integer> winningNumbers){
        return Utils.countCommonElements(numbers, winningNumbers);
    }

    public int getBonusCount(int bonusNumber){
        if(hasBonusNumber(bonusNumber)){
            return 1;
        }
        return 0;
    }

    private boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
