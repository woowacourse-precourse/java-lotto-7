package lotto.model;

import static lotto.model.Lotto.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static List<Lotto> generate(final int quantity){
        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_SIZE)))
                .toList();
    }
}
