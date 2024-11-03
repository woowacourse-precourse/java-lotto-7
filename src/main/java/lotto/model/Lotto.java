package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCountWithBonus(Lotto anotherLotto, LottoBonusNumber bonusNumber) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        int matchCount = 0;
        for (Integer number : anotherLotto.getNumbers()) {
            if (lottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        if (lottoNumbers.contains(bonusNumber.getNumber())) {
            matchCount++;
        }
        return matchCount;
    }

    public boolean isBonusMatched(LottoBonusNumber lottoBonusNumber) {
        return numbers.contains(lottoBonusNumber.getNumber());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || containsOutOfRangeNumber(numbers) || hasDuplicationNumbers(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 중복되지 않은 자연수 6개여야 합니다.");
        }
    }

    private boolean containsOutOfRangeNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDuplicationNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNames = new HashSet<>(numbers);
        if (uniqueNames.size() < numbers.size()) {
            return true;
        }
        return false;
    }
}
