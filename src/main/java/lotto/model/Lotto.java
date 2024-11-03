package lotto.model;

import lotto.constant.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(Constants.ERROR_NUMBER_MUST_BE_SIX);
        }
        Set<Integer> notDuplicateNumber = new HashSet<>(numbers);
        if(notDuplicateNumber.size() != numbers.size()){
            throw new IllegalArgumentException(Constants.ERROR_NO_DUPLICATE);
        }
        for (Integer number : numbers) {
            if (number < Constants.MIN_LOTTO_RANGE || number > Constants.MAX_LOTTO_RANGE) {
                throw new IllegalArgumentException(Constants.ERROR_NUMBER_BETWEEN_ONE_TO_FORTY_FIVE);
            }
        }

    }
    public List<Integer> getNumbers(){
        return numbers;
    }

    public int compareTo(Lotto other){
        int count = Constants.ZERO;
        for(int number : numbers){
            if(other.getNumbers().contains(number)){
                count++;
            }
        }return count;
    }

    public boolean hasBonusNumber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }
    private List<Integer> sortNumbers(List<Integer> numbers){

        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }



    // TODO: 추가 기능 구현
}
