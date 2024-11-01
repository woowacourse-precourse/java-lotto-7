package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoIssuer {
    private final List<Lotto> purchasedLottos;
    private final int money;

    public LottoIssuer(int money) {
        checkMoney(money);
        this.money = money;
        purchasedLottos = purchaseLottos();
    }

    private void checkMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.format());
        }
    }

    private List<Lotto> purchaseLottos() {
        int count = money / 1000;
        return IntStream.range(0, count)
                .mapToObj(it -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(Lotto::new)
                .toList();

    }
}
