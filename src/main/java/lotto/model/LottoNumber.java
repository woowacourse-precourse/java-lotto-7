package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private final List<List<Integer>> numbers;

    public LottoNumber() {
        numbers = new ArrayList<>();
    }

    public void add(LottoAmount lottoAmount, RandomNumber randomNumber) {
        for (int i = 0; i < lottoAmount.get(); ++i) {
            numbers.add(randomNumber.generate());
        }
    }

    public List<List<Integer>> get() {
        return numbers;
    }
}
