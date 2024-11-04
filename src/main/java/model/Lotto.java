package model;

import service.Validator;

import java.util.List;

public class Lotto {
    private final static Validator validator = new Validator();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validator.validateLottoCount(numbers);
        validator.validateDuplicatedWinningNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
