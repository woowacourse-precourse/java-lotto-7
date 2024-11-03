package lotto.model;

import lotto.constant.ExceptionMessage;
import lotto.constant.GameConfig;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != GameConfig.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE_ERROR);
        }
        for(int number: numbers){
            if(number < GameConfig.MIN_RANGE_NUMBER || number > GameConfig.MAX_RANGE_NUMBER ){
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER_ERROR);
            }
        }
        HashSet<Integer> duplicate = new HashSet<>(numbers);
        if(duplicate.size() != GameConfig.LOTTO_NUMBERS_COUNT){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

}
