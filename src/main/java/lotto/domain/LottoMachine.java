package lotto.domain;

import java.util.List;
import lotto.util.RandomNumbers;

public class LottoMachine {
    public static Lotto generateRandomLotto() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();
        return new Lotto(numbers);
    }
}
