package lotto.lottoModel;

import java.util.List;

public class HitLotto {
    private final List<Integer> numbers;

    public HitLotto(List<Integer> hitLotto) {
        this.numbers = hitLotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
