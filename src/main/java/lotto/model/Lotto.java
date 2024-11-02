package lotto.model;

import java.util.List;

public class Lotto {  //개수, 범위, 중복 유효성 검사
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateNumberCount(numbers);
        LottoValidator.validateNumberRange(numbers);
        LottoValidator.validateUniqueNumbers(numbers);
        // 숫자 형식 검증
        //LottoValidator.validateNumberIsNumeric(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}