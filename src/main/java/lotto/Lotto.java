package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countMatchingWinningNumbers(List<Integer> winningNumbers){
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(winningNumbers.get(i))) count++;
        }
        return count;
    }

    public boolean isMatchBonusNumber(int bonusNumber){
        for (int number : numbers){
            if (number == bonusNumber) return true;
        }
        return false;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (!isUnique(numbers))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    private boolean isUnique(List<Integer> numbers){
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        return numbers.size() == uniqueNumbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
