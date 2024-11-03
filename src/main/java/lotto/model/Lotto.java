package lotto.model;

import java.util.List;

public class Lotto {
    public enum LottoNumber {
        VALID(1, 45);

        private final int min;
        private final int max;

        LottoNumber(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean isValid(int number) {
            return number >= min && number <= max;
        }
    }

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
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
}
