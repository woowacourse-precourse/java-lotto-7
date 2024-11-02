package lotto.model;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateNumberCount(numbers);
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validateNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
