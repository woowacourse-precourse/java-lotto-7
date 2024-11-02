package lotto.drawsystem;

import java.util.List;

public class DrawResults {

    private List<List<Integer>> totalMainNumbers;
    private List<Integer> totalBonusNumbers;

    private DrawResults(List<List<Integer>> mainNumbers, List<Integer> totalBonusNumbers) {
        this.totalMainNumbers = mainNumbers;
        this.totalBonusNumbers = totalBonusNumbers;
    }

    public void addMainNumbers(List<Integer> mainNumbers) {
        totalMainNumbers.add(mainNumbers);
    }

    public void addBonusNumber(Integer bonusNumber) {
        totalBonusNumbers.add(bonusNumber);
    }
}
