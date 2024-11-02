package lotto;

import lotto.constant.LottoRange;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplication(numbers);
        validateLottoRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean isDuplicate = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (isDuplicate) {
            throw new IllegalArgumentException("[ERROR] 잘못된 당첨번호를 입력하셨습니다");
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        if (!LottoRange.isAvailableRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 범위를 벗어나는 숫자가 입력되었습니다");
        }
    }
}
