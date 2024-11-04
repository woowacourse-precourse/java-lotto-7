package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private List<Integer> winningNumber;
    private int bonusNum;
    private List<List<Integer>> lottoNumbers;
    

    

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


}
