package lotto;

import java.util.List;

public class Lotto {
    public static final int LOTTO_COUNT = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 로또 번호 6개 검사
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        // 로또 번호 중복 검사
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
        }

        // 로또 번호 범위 값 달성 검사
        if (!numbers.stream()
                    .allMatch(number -> number >= Lotto.MIN_VALUE && number <= Lotto.MAX_VALUE)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위가 잘못 설정되었습니다.");
        }
    }

    public int matchNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                            .filter(winningNumbers::contains)
                            .count();
    }

    public boolean matchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
