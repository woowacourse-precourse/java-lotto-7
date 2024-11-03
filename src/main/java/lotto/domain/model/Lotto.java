package lotto.domain.model;

import java.util.List;
import lotto.domain.service.ValidationService;

//로또 번호를 관리하는 클래스
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
        // 추가 검증: 중복 번호 검사
        ValidationService.validateWinningNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
