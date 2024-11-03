package lotto.model.purchase;

import java.util.List;
import lotto.model.draw.BonusNumber;
import lotto.model.draw.DrawNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Integer getNumberMatchCount(final DrawNumbers drawNumbers) {
        return (int) drawNumbers.getDrawNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(final BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
