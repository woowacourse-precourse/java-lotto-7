package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private List<Integer> winningNumber;
    private int bonusNum;
    private List<List<Integer>> lottoNumbers;
    

    public void setNumbers(List<Integer> winningNumber, int bonusNum, List<List<Integer>> lottoNumbers) {
        this.winningNumber = winningNumber;
        this.bonusNum = bonusNum;
        this.lottoNumbers = lottoNumbers;
    }

    public void resultPrint(int total) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] rankCount = calculateRankCount(); // 등수 카운트 계산
        printRankResults(rankCount);            // 결과 출력
        double profitRate = calculateProfitRate(rankCount, total); // 수익률 계산
        printProfitRate(profitRate);            // 수익률 출력
    }

    int[] calculateRankCount() {
        int[] rankCount = new int[LottoRank.values().length];

        for (List<Integer> ticket : lottoNumbers) {
            int matchCount = countMatches(ticket);
            boolean matchBonus = ticket.contains(bonusNum);
            LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
            rankCount[rank.ordinal()]++;
        }
        return rankCount;
    }

    private void printRankResults(int[] rankCount) {
        System.out.printf("3개 일치 (5,000원) - %d개%n", rankCount[LottoRank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", rankCount[LottoRank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", rankCount[LottoRank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", rankCount[LottoRank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", rankCount[LottoRank.FIRST.ordinal()]);
    }

    double calculateProfitRate(int[] rankCount, int total) {
        int totalPrize = calculateTotalPrize(rankCount);
        return (double) totalPrize / total * 0.1;
    }

    private int calculateTotalPrize(int[] rankCount) {
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += rankCount[rank.ordinal()] * rank.getPrize();
        }
        return totalPrize;
    }

    private void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    int countMatches(List<Integer> ticket) {
        int count = 0;
        for (Integer number : winningNumber) {
            if (ticket.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public enum LottoRank {
        FIRST(6, false, 2000000000),    
        SECOND(5, true, 30000000),      
        THIRD(5, false, 1500000),       
        FOURTH(4, false, 50000),        
        FIFTH(3, false, 5000),          
        NONE(0, false, 0);              

        private final int matchCount;
        private final boolean matchBonus;
        private final int prize;

        LottoRank(int matchCount, boolean matchBonus, int prize) {
            this.matchCount = matchCount;
            this.matchBonus = matchBonus;
            this.prize = prize;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public boolean isMatchBonus() {
            return matchBonus;
        }

        public int getPrize() {
            return prize;
        }

        public static LottoRank valueOf(int matchCount, boolean matchBonus) {
            for (LottoRank rank : values()) {
                if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                    return rank;
                }
            }
            return NONE;
        }
    }

	public void setWinningNumber(List<Integer> winningNumber2) {
		this.winningNumber = winningNumber2;
	}

}
