package lotto.model;

import lotto.exception.InputValidation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        String duplicateCheck = String.valueOf(numbers).replace("[","").replace("]","").replace(" ","");
        InputValidation.NOT_DUPLICATE_NUMBER.validate(duplicateCheck);
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
}
