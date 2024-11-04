package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        System.out.println(this.numbers);
    }

    public int countMatchedNumber(final List<Integer> winningLottoNumbers) {
        return numbers.stream()
                .filter(winningLottoNumbers::contains)
                .toList()
                .size();
    }

    public boolean isMatchedBonusNumber(final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
