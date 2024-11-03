package lotto.service;

import static lotto.constant.UserId.BUYER;
import static lotto.constant.UserId.OWNER;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.model.db.Lotto;
import lotto.model.db.Buyer;
import lotto.model.db.Owner;
import lotto.model.db.UserRepository;

public class LottoCalculationService {

    private static final Map<Integer, Long> RANK_TO_PRIZE_MONEY = new HashMap<>();
    private static final Map<Integer, Integer> MATCH_CNT_TO_RANK = new HashMap<>();

    private final UserRepository userRepository = UserRepository.getInstance();

    static {
        RANK_TO_PRIZE_MONEY.put(1, 2_000_000_000L);
        RANK_TO_PRIZE_MONEY.put(2, 30_000_000L);
        RANK_TO_PRIZE_MONEY.put(3, 1_500_000L);
        RANK_TO_PRIZE_MONEY.put(4, 50_000L);
        RANK_TO_PRIZE_MONEY.put(5, 5_000L);

        MATCH_CNT_TO_RANK.put(6, 1);
        MATCH_CNT_TO_RANK.put(5, 3);
        MATCH_CNT_TO_RANK.put(4, 4);
        MATCH_CNT_TO_RANK.put(3, 5);
    }

    public int[] getRankCnts() {
        Buyer buyer = (Buyer) userRepository.findById(BUYER);
        Owner owner = (Owner) userRepository.findById(OWNER);

        int[] rankCnts = new int[6];
        buyer.getLotties().stream()
                .map(lotto -> parseRank(lotto, owner.getWinningLotto(), owner.getBonus()))
                .filter(rank -> rank != -1)
                .forEach(rank -> rankCnts[rank]++);
        return rankCnts;
    }

    private int parseRank(Lotto lotto, Lotto winningLotto, int bonus) {
        int rank = MATCH_CNT_TO_RANK.getOrDefault(lotto.getMatchCnt(winningLotto), -1);
        if (isSecondLottoRank(lotto, bonus, rank)) {
            rank = 2;
        }
        return rank;
    }

    private static boolean isSecondLottoRank(Lotto lotto, int bonus, int rank) {
        return rank == 3 && lotto.contains(bonus);
    }

    public double getRateOfReturn(int[] rankCnts) {
        Buyer buyer = (Buyer) userRepository.findById(BUYER);
        double sum = IntStream.range(1, rankCnts.length)
                .mapToDouble(i -> (rankCnts[i] * RANK_TO_PRIZE_MONEY.get(i)))
                .sum();
        return sum / (buyer.getLottoCnt() * 1000) * 100;
    }
}
