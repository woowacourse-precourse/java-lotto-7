package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoIssuer {
    public static List<Lotto> issueLottos(int money) {
        checkMoney(money);
        int count = money / 1000;
        return IntStream.range(0, count)
                .mapToObj(it -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(Lotto::new)
                .toList();
    }

    private static void checkMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.format());
        }
    }
}
