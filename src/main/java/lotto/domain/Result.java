package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static lotto.domain.Budget.LOTTO_PRICE;

public class Result {

    public final List<Rank> ranks;

    public Result(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public Map<Rank, BigInteger> returnCounts() {
        Map<Rank, BigInteger> counts = Rank.createCounts();
        ranks.forEach(rank -> counts.put(rank, counts.get(rank).add(BigInteger.ONE)));
        return counts;
    }

    public BigDecimal returnRate() {
        BigDecimal sum = new BigDecimal(calculateSum());
        return sum.multiply(BigDecimal.valueOf(100L))
                .divide(new BigDecimal(ranks.size()).multiply(new BigDecimal(LOTTO_PRICE)), 1, RoundingMode.HALF_EVEN);
    }

    private BigInteger calculateSum() {
        BigInteger sum = BigInteger.ZERO;
        for (Rank rank : ranks) {
            sum = sum.add(BigInteger.valueOf(rank.prize));
        }
        return sum;
    }
}
