package lotto.domain.lottoForm;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.message.InfoMessage.NUMBER_DELIMITER;

public class Lotto implements LottoForm {
    private final List<LottoNumber> numbers;

    private Lotto(List<Integer> rawNumbers) {
        this.numbers = initializeNumbers(rawNumbers);
    }

    public static Lotto from(List<Integer> rawIntegers) {
        return new Lotto(rawIntegers);
    }

    @Override
    public String toString() {
        String result = numbers.stream()
                .map(LottoNumber::number)
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_DELIMITER.getMessage()));
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

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::isSame);
    }
}
