package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class LottoPublisher {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_COUNT_SIZE = 6;

    public static List<Lotto> publishLotto(PurchaseAmount purchaseAmount) {
        return Stream.generate(LottoPublisher::generateLotto)
                .limit(calculateLottoCount(purchaseAmount))
                .toList();
    }

    private static int calculateLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.value() / LOTTO_PRICE;
    }

    private static Lotto generateLotto() {
        return new Lotto(generateLottoNumber());
    }

    private static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}