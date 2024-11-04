package lotto.model;

import java.util.List;
import lotto.policy.LottoPolicy;
import lotto.policy.LottoPolicyImpl;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoPolicy lottoPolicy = new LottoPolicyImpl();
        lottoPolicy.checkLottoPolicy(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
