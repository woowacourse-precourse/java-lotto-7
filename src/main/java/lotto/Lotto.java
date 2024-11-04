package lotto;

import java.util.HashSet;
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
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        if (hasInvalidNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public int countMatchingNumbers(List<Integer> lottoNumber) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (lottoNumber.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean containsBonusNumber(int bonusNumber,List<Integer> lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private boolean hasInvalidNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }
}
