package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.MAX_LOTTO_NUMBER;
import static lotto.model.Lotto.MIN_LOTTO_NUMBER;

public class PublishLotteries {
    private static final int DRAW_NUMBER_COUNT = 6;

    private final List<Lotto> lotteries;

    public PublishLotteries(int purchaseCount) {
        this.lotteries = new ArrayList<>();
        publishing(purchaseCount);
    }

    public List<Lotto> get() {
        return lotteries;
    }

    private void publishing(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                    DRAW_NUMBER_COUNT);
            lotteries.add(new Lotto(numbers));
        }
    }
}
