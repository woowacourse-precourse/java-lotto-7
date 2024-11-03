package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Prize;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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
