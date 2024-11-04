package lotto.dto;

import java.util.List;
import lotto.model.LottoPrize;

public record LottoPrizeDto(int matchCount, boolean isBonusBallMatched, int money, int numberOfMatchedLotto) {
    public LottoPrizeDto(LottoPrize prize, List<LottoPrize> prizes) {
        this(prize.getMatchCount(), prize.isBonusBallMatched(), prize.getMoney(), prizes.size());
    }
}
