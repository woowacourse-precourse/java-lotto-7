package lotto.domain.model;

import java.util.List;

//로또 번호를 관리하는 클래스
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //로또 번호가 유효한지 검사
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER_ERROR.getMessage());
        }
    }

    // 중복된 번호가 있는지 검사
    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public List<Integer> getNumbers() {
        return numbers; // 외부에서 읽기만 가능하도록 설정
    }
}
