package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCount.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.get(1) + "개");
        printEarningRate();
    }

    public void printEarningRate() {
        System.out.println("총 수익률은 " + getEarningRate() + "%입니다.");
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
