package lotto.committee;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {

    private final List<List<Integer>> mainNumbers;
    private final List<Integer> bonusNumbers;

    private WinningNumbers(List<List<Integer>> mainNumbers, List<Integer> bonusNumbers) {
        this.mainNumbers = Collections.unmodifiableList(mainNumbers);
        this.bonusNumbers = Collections.unmodifiableList(bonusNumbers);
    }

    static WinningNumbers forTest(List<List<Integer>> mainNumbers, List<Integer> bonusNumbers) {
        return new WinningNumbers(mainNumbers, bonusNumbers);
    }

    public WinningNumbers getWinningNumbers() {
        return new WinningNumbers(mainNumbers, bonusNumbers);
    }

    public List<Integer> getMainNumbers() {
        List<Integer> wonMainNumber = mainNumbers.getFirst();
        return wonMainNumber;
    }

    public Integer getBonusNumber() {
        Integer wonBonusNumber = bonusNumbers.getFirst();
        return wonBonusNumber;
    }

    void addMainNumbers(List<Integer> mainNumbers) {
        this.mainNumbers.add(mainNumbers);
    }

    void addBonusNumber(Integer bonusNumber) {
        bonusNumbers.add(bonusNumber);
    }

    public Integer getMainSize() {
        return mainNumbers.size();
    }

    public Integer getBonusSize() {
        return bonusNumbers.size();
    }

}
