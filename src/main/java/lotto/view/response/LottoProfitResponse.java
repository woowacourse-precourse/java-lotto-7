package lotto.view.response;

import lotto.model.Score;

import java.util.List;

public class LottoProfitResponse {

    private final double profitRate;

    private LottoProfitResponse(double profitRate) {
        this.profitRate = profitRate;
    }

    public static LottoProfitResponse of(List<Score> scores, int purchaseMoney) {
        double profitRate = (double) scores.stream().mapToInt(Score::getPrize).sum() / purchaseMoney * 100;
        return new LottoProfitResponse(profitRate);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
