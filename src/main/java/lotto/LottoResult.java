package lotto;

import java.util.List;

public class LottoResult {

    private final List<LottoPrize> prizes;

    public LottoResult(List<LottoPrize> prizes) {
        this.prizes = prizes;
    }

    public List<LottoPrize> getPrizes() {
        return List.copyOf(prizes);
    }

    public List<LottoPrize> getPrizeFor(int matchCount) {
        return getPrizeFor(matchCount, false);
    }

    public List<LottoPrize> getPrizeFor(int matchCount, boolean isBonusBallMatched) {
        return this.prizes.stream()
                .filter(prize -> prize.isMatched(matchCount, isBonusBallMatched))
                .toList();
    }

    public List<LottoPrize> getPrizeFor(LottoPrize prize) {
        return prizes.stream()
                .filter(prize::equals)
                .toList();
    }
}
