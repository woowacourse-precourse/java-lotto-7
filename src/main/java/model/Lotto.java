package model;

import service.Validator;

import java.util.List;

public class Lotto {
    private final static Validator validator = new Validator();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validator.validateAmountCount(numbers);
        validator.validateDuplicatedBonusNumber(numbers);
        this.numbers = numbers;
    }

    private void validateNumbDuplicate(List<Integer> numbers) { //번호 중복 확인 메서드

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
