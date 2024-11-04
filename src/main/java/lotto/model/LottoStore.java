package lotto.model;

import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_BELOW_MINIMUM;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_MUST_BE_NUMBER;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lottos purchaseLottos(Money money) {
        int numberOfLottos = money.getNumberOfLottos();
        List<Lotto> lottos = generateLottosByCount(numberOfLottos);

        return new Lottos(numberOfLottos, lottos);
    }

    private List<Lotto> generateLottosByCount(long numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }

    public Lotto generateRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_COUNT));
    }
}
