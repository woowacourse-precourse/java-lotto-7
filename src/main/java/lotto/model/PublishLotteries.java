package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PublishLotteries {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int DRAW_NUMBER_COUNT = 6;

    private final List<Lotto> lotteries;

    public PublishLotteries(int purchaseCount) {
        this.lotteries = new ArrayList<>();
        publish(purchaseCount);
    }

    public List<Lotto> get() {
        return lotteries;
    }

    private void publish(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                    DRAW_NUMBER_COUNT);
            lotteries.add(new Lotto(numbers));
        }
    }
}
