package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 추가적인 validation을 대비해 validate 매서드 생성
    private void validate(List<Integer> numbers) {
        validateSizeOfNumber(numbers);
        validateDuplicatedNumber(numbers);
        validateIsOverRange(numbers);
    }

    private void validateSizeOfNumber(List<Integer> numbers) {
        final int LOTTO_SIZE = 6;
        final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        final String LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호에서 중복되는 숫자가 존재하면 안됩니다.";
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateIsOverRange(List<Integer> numbers){
        final String LOTTO_NUMBER_OVER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호가 1 ~ 45 범위를 벗어나면 안됩니다.";
        final int MIN = 1;
        final int MAX = 45;
        if(numbers.stream().anyMatch(num -> num < MIN || num > MAX)){
            throw new IllegalArgumentException(LOTTO_NUMBER_OVER_RANGE_ERROR_MESSAGE);
        }
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    // TODO: 추가 기능 구현
}
