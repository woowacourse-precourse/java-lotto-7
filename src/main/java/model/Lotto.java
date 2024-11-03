package model;

import java.util.List;
import validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateUniqueElements(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public LottoResult lottoCalculation(List<Integer> winningNumbers, Integer bonusNumber) {
        int correctCount = lottoMatch(winningNumbers);
        if (correctCount == 6) {
            return LottoResult.FIRST;
        }
        if (correctCount == 5) {
            return bonusMatch(bonusNumber);
        }
        if (correctCount == 4) {
            return LottoResult.FOURTH;
        }
        if (correctCount == 3) {
            return LottoResult.FIFTH;
        }
        return LottoResult.FAIL;
    }

    private int lottoMatch(List<Integer> winningNumbers) {
        int mathResult = 0;
        for (Integer winningNumber : winningNumbers) {
            mathResult += elementMatch(winningNumber);
        }
        return mathResult;
    }

    private int elementMatch(Integer targetNumber) {
        if (numbers.contains(targetNumber)) {
            return 1;
        }
        return 0;
    }

    private LottoResult bonusMatch(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return LottoResult.SECOND;
        }
        return LottoResult.THIRD;
    }
}
