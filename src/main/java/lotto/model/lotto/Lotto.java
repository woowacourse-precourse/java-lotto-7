package lotto.model.lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        isLottoSizeSix(numbers);

        isLottoNotDuplicated(numbers);

        for (Integer number : numbers) {

            isLottoNegative(number);

            isLottoInRange(number);
        }

    }

    private void isLottoSizeSix(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isLottoNotDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().toList().size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
        }
    }

    private void isLottoNegative(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 음수를 입력할 수 없습니다.");
        }
    }

    private void isLottoInRange(Integer number) {
        if (number < LottoRange.MIN_NUMBER.getDescription() || number > LottoRange.MAX_NUMBER.getDescription()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자를 입력해주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
