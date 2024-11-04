package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> issueLottos(int lottoCount) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            lottos.add(new Lotto(Random.pickUniqueNumbersInRange()));
        }
        return lottos;
    }

    public static int purchasableLottoCount(int purchasePrice, int price) {
        validateDivisible(purchasePrice,price);
        return purchasePrice/price;
    }

    public static void validateDivisible(final int divided, final int dividend) {
        if(divided % dividend != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 "+ dividend +" 단위로 입력해야 합니다.");
        }
    }
}
