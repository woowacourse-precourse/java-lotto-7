package lotto.domain;

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

    public BigInteger totalPrizeAmount() {
        BigInteger total = BigInteger.ZERO;
        for (Rank rank : ranks) {
            total = total.add(rank.getPrizeAmount());
        }
        return total;
    }
}
