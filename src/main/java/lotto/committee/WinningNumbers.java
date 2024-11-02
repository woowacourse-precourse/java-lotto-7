package lotto.committee;

import java.util.List;
import java.util.TreeSet;
import lotto.drawsystem.DrawMachine;

public class WinningNumbers {

    private final List<Integer> mainNumbers;
    private final Integer bonusNumber;

    private WinningNumbers(List<Integer> mainNumbers, Integer bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers getWinningNumbers() {
        return new WinningNumbers(mainNumbers, bonusNumber);
    }

    public List<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private WinningNumbers runWinningNumbers() {
        DrawMachine drawMachine = new DrawMachine();
         = drawMachine.runSingleDraw();

    }
}
