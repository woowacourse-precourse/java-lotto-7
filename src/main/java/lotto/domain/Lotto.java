package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortLottoNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(Integer number : numbers){
            if (number < Constants.LOTTO_MIN_NUM || number > Constants.LOTTO_MAX_NUM) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이어야 합니다.");
            }
        }

    }

    private void sortLottoNumbers() {
        Collections.sort(this.numbers);
    }
}
