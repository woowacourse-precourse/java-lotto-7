package lotto.service;

import static lotto.constant.UserId.BUYER;
import static lotto.constant.UserId.OWNER;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.model.LottoRankCounter;
import lotto.model.db.Buyer;
import lotto.model.db.Owner;
import lotto.model.db.UserRepository;

public class LottoCalculationService {

    private static final Map<Integer, Long> RANK_TO_PRIZE_MONEY = new HashMap<>();
    private static final int PRICE_PER_LOTTO = 1_000;

    private final UserRepository userRepository = UserRepository.getInstance();

    static {
        RANK_TO_PRIZE_MONEY.put(1, 2_000_000_000L);
        RANK_TO_PRIZE_MONEY.put(2, 30_000_000L);
        RANK_TO_PRIZE_MONEY.put(3, 1_500_000L);
        RANK_TO_PRIZE_MONEY.put(4, 50_000L);
        RANK_TO_PRIZE_MONEY.put(5, 5_000L);
    }

    public LottoRankCounter getRankCnts() {
        Buyer buyer = (Buyer) userRepository.findById(BUYER);
        Owner owner = (Owner) userRepository.findById(OWNER);
        return new LottoRankCounter(buyer.getLotties(), owner.getWinningLotto(), owner.getBonus());
    }

    public double getRateOfReturn(LottoRankCounter rankCnts) {
        Buyer buyer = (Buyer) userRepository.findById(BUYER);
        double sum = IntStream.rangeClosed(rankCnts.getFirstRank(), rankCnts.size())
                .mapToDouble(rank -> calcReturn(rankCnts, rank))
                .sum();
        return calcRateOfReturn(sum, buyer.getLottoCnt());
    }

    private double calcRateOfReturn(double sum, int lottoCnt) {
        return sum / (lottoCnt * PRICE_PER_LOTTO) * 100;
    }

    private long calcReturn(LottoRankCounter rankCnts, int rank) {
        return rankCnts.getCnt(rank) * RANK_TO_PRIZE_MONEY.get(rank);
    }
}
