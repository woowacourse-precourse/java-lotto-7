package lotto.drawsystem;

import java.util.List;

public class DrawResults {

        List<List<Integer>> totalMainNumbers;
        List<Integer> totalBonusNumbers;

        public DrawResults(List<List<Integer>> mainNumbers, List<Integer> totalBonusNumbers) {
            this.totalMainNumbers = mainNumbers;
            this.totalBonusNumbers = totalBonusNumbers;
        }
}
