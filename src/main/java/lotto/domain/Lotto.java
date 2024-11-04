package lotto.domain;

import java.util.List;
import lotto.config.LottoGameConfig;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoGameConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoGameConfig.LOTTO_SIZE + "개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != LottoGameConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < LottoGameConfig.LOTTO_MIN_NUMBER
                || number > LottoGameConfig.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + LottoGameConfig.LOTTO_MIN_NUMBER + "부터 "
                            + LottoGameConfig.LOTTO_MAX_NUMBER + " 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
