package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws RuntimeException{
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws RuntimeException{
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 다른 구분자 있는지도 확인하기

    // TODO: 추가 기능 구현
    public List<Integer> getLottoNumber() {
        return numbers;
    }
}
