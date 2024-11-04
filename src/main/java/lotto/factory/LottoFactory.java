package lotto.factory;

import java.util.List;
import lotto.model.Lotto;

public class LottoFactory {
    public static Lotto creatLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
