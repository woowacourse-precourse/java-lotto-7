package lotto.model;

import static lotto.common.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.common.ErrorMessage.NUMBER_OUT_OF_RANGE;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isNumberBetween1And45(numbers);
        checkForDuplicates(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isNumberBetween1And45(List<Integer> numbers){
        for(Integer i : numbers){
            if(i < 1 || i > 45){
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.format());
            }
        }
    }

    private void checkForDuplicates(List<Integer> numbers){
        HashSet<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.format());
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
