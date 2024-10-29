package lotto.model;

import static lotto.utils.Constants.*;

import java.util.HashSet;
import java.util.List;
import lotto.utils.Constants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLottoNumbersSize(numbers);
        checkLottoNumberIsDuplicate(numbers);
        checkLottoNumberRange(numbers);
    }

    private void checkLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    private void checkLottoNumberIsDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void checkLottoNumberRange(List<Integer> numbers){
        for (Integer num : numbers){
            if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이여야 합니다.");
        }
    }
}
