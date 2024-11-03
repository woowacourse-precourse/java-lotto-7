package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
