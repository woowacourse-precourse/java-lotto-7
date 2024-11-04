package lotto.model.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int number : numbers) {
            if (!LottoNumber.VALID.isValid(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다: " + number);
            }
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 당첨 번호와의 일치 개수를 반환하는 메서드
    public int getMatchCount(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : winningNumbers) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    // 보너스 번호 포함 여부를 확인하는 메서드
    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    // 보너스 번호 유효성
    public boolean isBonusNumberValid(int bonusNumber) {
        return !numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
