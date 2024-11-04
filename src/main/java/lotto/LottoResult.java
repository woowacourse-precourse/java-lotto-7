package lotto;

import java.util.HashMap;
import java.util.Map;

import static constant.Message.*;
import static constant.RankInfo.*;

public class LottoResult {
    private static final int PRICE_UNIT = 1000;
    private static final int PERCENTAGE = 100;

    private Map<Integer, Integer> rankCount;
    private final LottoTickets lottoTickets;
    private final LottoNumbers lottoNumbers;
    public LottoResult(LottoTickets lottoTickets, LottoNumbers lottoNumbers) {
        this.lottoTickets = lottoTickets;
        this.lottoNumbers = lottoNumbers;
        initRankCount();
    }

    public void initRankCount() {
        rankCount = new HashMap<>();
        for (int rank = RANK_1.value(); rank <= RANK_5.value(); rank++) {
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
        int rank = calculateRank(matchCount, hasBonusNumber);
        if (rank != UNRANKED.value()) {
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
    }

    public int calculateRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount < RANK_5_THRESHOLD.value()) {
            return UNRANKED.value();
        }
        if (matchCount < RANK_4_THRESHOLD.value()) {
            return RANK_5.value();
        }
        if (matchCount < RANK_3_THRESHOLD.value()) {
            return RANK_4.value();
        }
        if (matchCount >= RANK_1_THRESHOLD.value()) {
            return RANK_1.value();
        }
        return calculateRankTwoOrThree(hasBonusNumber);
    }

    public int calculateRankTwoOrThree(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return RANK_2.value();
        }
        return RANK_3.value();
    }

    public void print() {
        System.out.println("\n" + PRINT_LOTTO_STATICS.getMessage());
        System.out.println(PRINT_LINE.getMessage());
        System.out.println(FIFTH_RANK.getMessage() + rankCount.get(RANK_5.value()) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(FOURTH_RANK.getMessage() + rankCount.get(RANK_4.value()) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(THIRD_RANK.getMessage() + rankCount.get(RANK_3.value()) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(SECOND_RANK.getMessage() + rankCount.get(RANK_2.value()) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(FIRST_RANK.getMessage() + rankCount.get(RANK_1.value()) + SUFFIX_RANK_COUNT.getMessage());
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

    public double roundToOneDecimal(double value) {
        return Math.round(value * 10) / 10.0;
    }

    public int getEarning() {
        int earning = 0;
        earning += PRIZE_RANK_5.value() * rankCount.get(RANK_5.value());
        earning += PRIZE_RANK_4.value() * rankCount.get(RANK_4.value());
        earning += PRIZE_RANK_3.value() * rankCount.get(RANK_3.value());
        earning += PRIZE_RANK_2.value() * rankCount.get(RANK_2.value());
        earning += PRIZE_RANK_1.value() * rankCount.get(RANK_1.value());
        return earning;
    }

    // 테스트용 코드
    public int getCountOfRank(int rank) {
        return rankCount.get(rank);
    }
}
