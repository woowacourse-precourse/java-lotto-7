package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoIssuer {
    public static List<Lotto> issueLottos(int money) {
        int count = money / 1000;
        return IntStream.range(0, count)
                .mapToObj(it -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(Lotto::new)
                .toList();
    }
}
