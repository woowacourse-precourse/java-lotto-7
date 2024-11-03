package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public int count() {
        return ranks.size();
    }

    public Money totalPrizeAmount() {
        BigInteger total = BigInteger.ZERO;
        for (Rank rank : ranks) {
            total = total.add(rank.getPrizeAmount());
        }
        return new Money(total);
    }

    public BigDecimal calculateProfitRate(Money purchaseAmount) {
        Money totalPrizeAmount = totalPrizeAmount();
        return totalPrizeAmount.ratePercentage(purchaseAmount);
    }

    public List<Rank> getPrizeRanks() {
        return this.ranks.stream()
                .filter(Rank::isPrizeRank)
                .toList();
    }

}
