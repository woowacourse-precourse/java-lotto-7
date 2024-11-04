package lotto.domain;

import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호 중 중복된 번호가 있습니다.");
        }
    }

    public int countWinningMatches(List<Integer> winningLottoNumbers) {
        return (int) numbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    public boolean hasBonusMatch(int bonusLottoNumber) {
        return numbers.contains(bonusLottoNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
