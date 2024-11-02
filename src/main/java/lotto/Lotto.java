package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidNumberRange(numbers);
        isDuplicate(numbers);
        isValidNumberSize(numbers);
        Collections.sort(numbers);
    }

    private void isValidNumberSize(List<Integer> numbers) {
        final int LOTTO_SIZE = 6;
        if(numbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isValidNumberRange(List<Integer> numbers){
        final Integer LOTTO_MIN_NUM = 1;
        final Integer LOTTO_MAX_NUM = 45;

        for(Integer Number: numbers){
            if((Number < LOTTO_MIN_NUM) || (Number > LOTTO_MAX_NUM)){
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void isDuplicate(List<Integer> numbers){
        List<Integer> duplicateNumbers = new ArrayList<>();
        for(Integer Number: numbers){
            if(duplicateNumbers.contains(Number)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            }
            duplicateNumbers.add(Number);
        }
    }

    protected List<Integer> getLottoNumber(){
        return numbers;
    }
}
