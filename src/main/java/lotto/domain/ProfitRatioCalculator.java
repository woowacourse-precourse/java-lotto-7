package lotto.domain;

import static lotto.constant.Constant.*;

import java.util.List;
import lotto.Lotto;

public class ProfitRatioCalculator {

    private final int[] rank;

    private final List<Lotto> myLottos;

    public ProfitRatioCalculator(int[] rank, List<Lotto> myLottos) {
        this.rank = rank;
        this.myLottos = myLottos;
    }

    public float calculateProfitRatio() {
        int sum = rank[FIFTH_PLACE_INDEX] * FIFTH_PLACE_PRIZE
                + rank[FOURTH_PLACE_INDEX] * FOURTH_PLACE_PRIZE
                + rank[THIRD_PLACE_INDEX] * THIRD_PLACE_PRIZE
                + rank[SECOND_PLACE_INDEX] * SECOND_PLACE_PRIZE
                + rank[FIRST_PLACE_INDEX] * FIRST_PLACE_PRIZE;
        return ((float) sum / (myLottos.size() * LOTTO_PRICE)) * 100;
    }
}
