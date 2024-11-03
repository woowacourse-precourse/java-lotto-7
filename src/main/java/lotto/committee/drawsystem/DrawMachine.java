package lotto.committee.drawsystem;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class DrawMachine {

    private final WinningNumbers winningNumbers;

    private DrawMachine(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    static DrawMachine forTest(WinningNumbers winningNumbers) {
        DrawMachine objForTest = new DrawMachine(winningNumbers);
        objForTest.runDraw();
        return objForTest;
    }

    void runDraw() {
        List<Integer> mainNumbers = drawMainNumbers();
        Integer bonusNumber = drawBonusNumber(mainNumbers);
        addDrawResult(mainNumbers, bonusNumber);
    }

    private void addDrawResult(List<Integer> mainNumbers, Integer bonusNumber) {
            winningNumbers.addMainNumbers(mainNumbers);
            winningNumbers.addBonusNumber(bonusNumber);
    }

    private List<Integer> drawMainNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Integer drawBonusNumber(List<Integer> mainNumbers) {
        Integer bonusNumber = initBonusNumber();
        bonusNumber = makeUnique(mainNumbers, bonusNumber);

        return bonusNumber;
    }

    private Integer initBonusNumber() {
        return Randoms.pickNumberInRange(1,45);
    }

    private Integer makeUnique(List<Integer> mainNumbers, Integer bonusNumber) {
        boolean result = true;
        while (result == true) {
            bonusNumber = initBonusNumber();
            result = isBonusNumberAlready(mainNumbers, bonusNumber);
        }
        return bonusNumber;
    }

    private boolean isBonusNumberAlready(List<Integer> mainNumbers, Integer bonusNumber) {
        return mainNumbers.contains(bonusNumber);
    }
}
