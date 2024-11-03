package lotto;

import java.util.List;
import lotto.domain.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getWinningNumberCount(List<Integer> inputNumbers) {
        int count = 0;
        for (Integer inputNumber : inputNumbers) {
            if(numbers.contains(inputNumber)) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        List<Integer> list = numbers.stream().sorted().toList();
        return list.toString();
    }
}
