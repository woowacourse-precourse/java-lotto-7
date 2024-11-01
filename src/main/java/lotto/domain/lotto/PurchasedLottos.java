package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {

    private final List<Lotto> purchaseLottos;

    private PurchasedLottos(final int count) {
        purchaseLottos = new ArrayList<>();

    }

    public static PurchasedLottos from(final int count) {
        return new PurchasedLottos(count);
    }

    private void generateRandomNumber(final int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstant.MIN_LOTTO_NUMBER,
                    LottoConstant.MAX_LOTTO_NUMBER,
                    LottoConstant.LOTTO_SIZE
            );
            purchaseLottos.add(Lotto.from(numbers));
        }
    }
}