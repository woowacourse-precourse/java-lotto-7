package lotto.domain.lottoForm;

import lotto.domain.number.Number;
import lotto.domain.number.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto extends LottoForm {
    private final String DELIMITER = ", ";
    private final List<Integer> numbers;
    private final List<LottoNumber> numbers2;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateAndSort(numbers);
        this.numbers2 = validateAndSort(numbers).stream()
                .map(LottoNumber::new)
                .toList();
    }

    @Override
    public String toString() {
        String result = numbers2.stream()
                .map(Number::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        return String.format("[%s]", result);
    }

    public List<LottoNumber> getNumbers() {
        return numbers2;
    }

    public int getMatchingNumbers(WinningNumbers winningNumbers) {
        return Math.toIntExact(numbers2.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean hasBonusNumber(Number bonusNumber) {
        return numbers2.stream()
                .anyMatch(bonusNumber::isSame);
    }
}
