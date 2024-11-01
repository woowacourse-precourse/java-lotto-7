package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final List<LottoNumber> numbers;

    public Numbers(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public int matchCount(Numbers otherNumbers) {
        int count = 0;
        for (LottoNumber number : this.numbers) {
            if (otherNumbers.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean matchBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
