package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static constant.Message.*;

public class LottoResult {

    private Map<Integer, Integer> rankCount;
    private final ArrayList<Lotto> lottoTickets;
    private final ArrayList<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult(ArrayList<Lotto> lottoTickets, ArrayList<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initRankCount();
        checkResult();
    }

    private void initRankCount() {
        rankCount = new HashMap<>();
        for (int rank = 1; rank <= 5; rank++) {
            rankCount.put(rank, 0);
        }
    }

    public void checkResult() {
        for (Lotto lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getMatchCount(winningNumbers);
            boolean hasBonusNumber = lottoTicket.hasBonusNumber(bonusNumber);
            update(matchCount, hasBonusNumber);
        }
    }

    public void update(int matchCount, boolean hasBonusNumber) {
        int rank = getRank(matchCount, hasBonusNumber);
        if (rank != -1) {
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
    }

    private int getRank(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 6)
            return 1;
        if (matchCount == 5 && hasBonusNumber)
            return 2;
        if (matchCount == 5)
            return 3;
        if (matchCount == 4)
            return 4;
        if (matchCount == 3)
            return 5;
        return -1;
    }

    public void print() {
        System.out.println("\n" + PRINT_LOTTO_STATICS.getMessage());
        System.out.println(PRINT_LINE.getMessage());
        System.out.println(FIFTH_RANK.getMessage() + rankCount.get(5) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(FOURTH_RANK.getMessage() + rankCount.get(4) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(THIRD_RANK.getMessage() + rankCount.get(3) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(SECOND_RANK.getMessage() + rankCount.get(2) + SUFFIX_RANK_COUNT.getMessage());
        System.out.println(FIRST_RANK.getMessage() + rankCount.get(1) + SUFFIX_RANK_COUNT.getMessage());
        printEarningRate();
    }

    public void printEarningRate() {
        System.out.println(PREFIX_EARNING_RATE.getMessage() + getEarningRate() + SUFFIX_EARNING_RATE.getMessage());
    }

    public double getEarningRate() {
        int purchaseAmount = lottoTickets.size() * 1000;
        int earning = getEarning();
        double earningRate = (double) earning /purchaseAmount;
        return Math.round(earningRate * 10) / 10.0;
    }

    public int getEarning() {
        int earning = 0;
        earning += 5000 * rankCount.get(5);
        earning += 50000 * rankCount.get(4);
        earning += 1500000 * rankCount.get(3);
        earning += 30000000 * rankCount.get(2);
        earning += 2000000000 * rankCount.get(1);
        return earning;
    }
}
