package lotto.domain;

import lotto.config.LottoConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정확히 " + LottoConfig.LOTTO_SIZE + "개여야 합니다. 현재 개수: " + numbers.size());
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConfig.START_NUMBER || number > LottoConfig.END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoConfig.START_NUMBER +" 이상 " + LottoConfig.END_NUMBER + " 이하의 숫자여야 합니다. 현재 숫자: " + number);
            }
        }
    }

    public Rank match(Lotto winningNumbers, int bonusNumber) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        boolean hasBonus = numbers.contains(bonusNumber);
        return Rank.fromMatchCount(matchCount, hasBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
