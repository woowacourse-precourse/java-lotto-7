package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoGameInformation.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoGameInformation.LOTTO_SIZE + "개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != LottoGameInformation.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < LottoGameInformation.LOTTO_MIN_NUMBER
                || number > LottoGameInformation.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + LottoGameInformation.LOTTO_MIN_NUMBER + "부터 "
                            + LottoGameInformation.LOTTO_MAX_NUMBER + " 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
