package lotto.domain.lottoForm;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.Number;

import java.util.List;

public class Lotto extends LottoForm {
    private final String DELIMITER = ", ";
    private final List<Integer> numbers;
    private final List<Number> numbers2;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateAndSort(numbers);
        this.numbers2 = validateAndSort(numbers).stream()
                .map(Number::new)
                .toList();
    }

    @Override
    public String toString() {
//        return String.join(DELIMITER, numbers.toString());
        return numbers2.stream()
                .map(LottoNumber::getNumber)
                .toString();
    }

    public List<Number> getNumbers() {
        return numbers2;
    }

    public int getMatchingNumbers(WinningNumbers winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
