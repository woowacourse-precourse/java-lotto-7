package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.global.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLottos {

    private final List<Lotto> purchaseLottos;

    private PurchasedLottos(final int count) {
        purchaseLottos = new ArrayList<>();
        generateLottos(count);
    }

    public static PurchasedLottos from(final int count) {
        return new PurchasedLottos(count);
    }

    private void generateLottos(final int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generateRandomNumber();
            purchaseLottos.add(Lotto.from(numbers));
        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO_NUMBER,
                LottoConstant.MAX_LOTTO_NUMBER,
                LottoConstant.LOTTO_SIZE
        ));
        return numbers;
    }

    public List<Lotto> getPurchasedLottos() {
        return Collections.unmodifiableList(purchaseLottos);
    }
}