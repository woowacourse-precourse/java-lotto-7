package lotto.domain.lottoForm;

import lotto.domain.number.Number;
import lotto.domain.number.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto extends LottoForm {
    private final String DELIMITER = ", ";

    private Lotto(List<Integer> rawNumbers) {
        super(rawNumbers);
    }

    public static Lotto from(List<Integer> rawIntegers) {
        return new Lotto(rawIntegers);
    }

    @Override
    public String toString() {
        String result = numbers.stream()
                .map(Number::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        return String.format("[%s]", result);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int getMatchingNumbers(WinningNumbers winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean hasBonusNumber(Number bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::isSame);
    }
}
