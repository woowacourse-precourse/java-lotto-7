package lotto.model;

import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {  //개수, 범위, 중복 유효성 검사
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateUniqueNumbers(numbers);
        // 숫자 형식 검증
        //LottoValidator.validateNumberIsNumeric(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        LottoValidator.validateNumberCount(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        LottoValidator.validateNumberRange(numbers);
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        LottoValidator.validateUniqueNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}