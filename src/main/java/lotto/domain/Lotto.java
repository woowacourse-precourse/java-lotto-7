package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Prize;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validSize(numbers);
        LottoValidator.validateNumberRange(numbers);
        LottoValidator.checkDuplicateNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        String sortedNumbers = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("[" + sortedNumbers + "]");
    }

    public Prize match(Lotto winningNumber, BonusNumber bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(number -> winningNumber.getNumbers().contains(number))
                .count();

        boolean matchBonus = numbers.stream()
                .anyMatch(number -> number == bonusNumber.getValue());

        return Prize.getPrize(matchCount, matchBonus);
    }
}
