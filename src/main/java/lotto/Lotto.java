package lotto;

import java.util.*;
import java.util.stream.Collectors;

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
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public Prize match(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = numbers.contains(bonusNumber);

        return Prize.of(matchCount, matchBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}