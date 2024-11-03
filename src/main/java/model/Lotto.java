package model;

import java.util.List;
import policy.LottoPolicy;
import policy.LottoPolicyImpl;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoPolicy lottoPolicy = new LottoPolicyImpl();
        lottoPolicy.checkLottoPolicy(numbers);
        this.numbers = numbers;
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
