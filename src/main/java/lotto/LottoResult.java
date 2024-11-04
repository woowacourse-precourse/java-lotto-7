package lotto;

import java.util.HashMap;
import java.util.Map;

import static constant.Message.*;

public class LottoResult {
    private static final int RANK_1 = 1;
    private static final int RANK_2 = 2;
    private static final int RANK_3 = 3;
    private static final int RANK_4 = 4;
    private static final int RANK_5 = 5;
    private static final int UNRANKED = -1;
    private static final int RANK_1_THRESHOLD = 6;
    private static final int RANK_3_THRESHOLD = 5;
    private static final int RANK_4_THRESHOLD = 4;
    private static final int RANK_5_THRESHOLD = 3;
    private static final int PRICE_UNIT = 1000;
    private static final int PERCENTAGE = 100;
    private static final int PRIZE_RANK_5 = 5000;
    private static final int PRIZE_RANK_4 = 50000;
    private static final int PRIZE_RANK_3 = 1500000;
    private static final int PRIZE_RANK_2 = 30000000;
    private static final int PRIZE_RANK_1 = 2000000000;


    private Map<Integer, Integer> rankCount;
    private final LottoTickets lottoTickets;
    private final LottoNumbers lottoNumbers;

    public LottoResult(LottoTickets lottoTickets, LottoNumbers lottoNumbers) {
        this.lottoTickets = lottoTickets;
        this.lottoNumbers = lottoNumbers;
        initRankCount();
        checkResult();
    }

    private void initRankCount() {
        rankCount = new HashMap<>();
        for (int rank = RANK_1; rank <= RANK_5; rank++) {
            rankCount.put(rank, 0);
        }
    }

    public void checkResult() {
        for (Lotto lottoTicket : lottoTickets.getList()) {
            int matchCount = lottoTicket.getMatchCount(lottoNumbers.getWinningNumbers());
            boolean hasBonusNumber = lottoTicket.hasBonusNumber(lottoNumbers.getBonusNumber());
            update(matchCount, hasBonusNumber);
        }
    }

    public void update(int matchCount, boolean hasBonusNumber) {
        int rank = getRank(matchCount, hasBonusNumber);
        if (rank != UNRANKED) {
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
    }

    private int getRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount == RANK_1_THRESHOLD)
            return RANK_1;
        if (matchCount == RANK_3_THRESHOLD && hasBonusNumber)
            return RANK_2;
        if (matchCount == RANK_3_THRESHOLD)
            return RANK_3;
        if (matchCount == RANK_4_THRESHOLD)
            return RANK_4;
        if (matchCount == RANK_5_THRESHOLD)
            return RANK_5;
        return UNRANKED;
    }

    public void print() {
        System.out.println("\n" + PRINT_LOTTO_STATICS.getMessage());
        System.out.println(PRINT_LINE.getMessage());
        System.out.println(FIFTH_RANK.getMessage() + rankCount.get(RANK_5) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(FOURTH_RANK.getMessage() + rankCount.get(RANK_4) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(THIRD_RANK.getMessage() + rankCount.get(RANK_3) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(SECOND_RANK.getMessage() + rankCount.get(RANK_2) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(FIRST_RANK.getMessage() + rankCount.get(RANK_1) + SUFFIX_RANK_COUNT.getMessage());
        printEarningRate();
    }

    public void printEarningRate() {
        System.out.println(PREFIX_EARNING_RATE.getMessage() + getEarningRate() + SUFFIX_EARNING_RATE.getMessage());
    }

    public double getEarningRate() {
        int purchaseAmount = lottoTickets.size() * PRICE_UNIT;
        int earning = getEarning();
        double earningRate = (double) earning /purchaseAmount * PERCENTAGE;
        return roundToOneDecimal(earningRate);
    }

    private static double roundToOneDecimal(double value) {
        return Math.round(value * 10) / 10.0;
    }

    public int getEarning() {
        int earning = 0;
        earning += PRIZE_RANK_5 * rankCount.get(RANK_5);
        earning += PRIZE_RANK_4 * rankCount.get(RANK_4);
        earning += PRIZE_RANK_3 * rankCount.get(RANK_3);
        earning += PRIZE_RANK_2 * rankCount.get(RANK_2);
        earning += PRIZE_RANK_1 * rankCount.get(RANK_1);
        return earning;
    }
}
