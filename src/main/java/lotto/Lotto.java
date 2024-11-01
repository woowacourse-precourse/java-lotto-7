package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        final int LOTTO_SIZE = LottoGameInformation.LOTTO_SIZE.getValue();
        final int LOTTO_MIN_NUMBER = LottoGameInformation.LOTTO_MIN_NUMBER.getValue();
        final int LOTTO_MAX_NUMBER = LottoGameInformation.LOTTO_MAX_NUMBER.getValue();

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_SIZE + "개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + LOTTO_MIN_NUMBER + "부터 " + LOTTO_MAX_NUMBER + " 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
