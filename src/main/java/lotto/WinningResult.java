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

    }

	public void setWinningNumber(List<Integer> winningNumber2) {
		this.winningNumber = winningNumber2;
	}

}
