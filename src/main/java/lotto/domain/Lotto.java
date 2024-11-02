package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.validator.LottoValidator;
import lotto.validator.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator<List<Integer>> validator = new LottoValidator();
        validator.validate(numbers);
    }

    public long winningCount(List<Integer> winningNumbers, Map<String, Integer> map) {
        int count = 0;
        for (int i = 0; i < winningNumbers.size() - 1; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        if (count == 5 && numbers.contains(winningNumbers.getLast())) {
            count *= 2;
        }
        Winning[] winnings = Winning.values();
        for (Winning winning : winnings) {
            if (winning.getCount() == count) {
                map.put(winning.getMean(), map.get(winning.getMean()) + 1);
                return winning.getPrice();
            }
        }
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
