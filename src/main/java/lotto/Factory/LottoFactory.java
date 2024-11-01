package lotto.Factory;

import java.util.List;
import lotto.domain.Lotto;

public class LottoFactory {

    public static Lotto create(List<Integer> number) {
        return new Lotto(number);
    }
}
