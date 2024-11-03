package lotto;

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
        if(!Validation.isUnique(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되서는 안됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchWinningNumber(List<Integer> winningNumber) {
        int count = 0;
        for(int number:numbers) {
            if(winningNumber.contains(number)){
                count++;
            }
        }
        return count;
    }

    public boolean matchBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }
}
