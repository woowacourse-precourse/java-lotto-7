package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    // LottoTest를 수정하지 않기 위해 접근지정자 유지
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createUserLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

    public static Lotto createWinningLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
