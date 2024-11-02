package lotto.drawsystem;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;

public class DrawMachine {

    DrawResults drawResults;

    public DrawResults runDraws(Integer amount) {
        for (int drawCount = 0; drawCount < amount; amount++) {
            runSingleDraw();
        }
        return drawResults;
    }


    public void runSingleDraw() {
        List<Integer> mainNumbers = drawMainNumbers();
        Integer bonusNumber = drawBonusNumber(mainNumbers);
        addSingleResult(mainNumbers, bonusNumber);
    }

    private void addSingleResult(List<Integer> mainNumbers, Integer bonusNumber) {
            drawResults.addMainNumbers(mainNumbers);
            drawResults.addBonusNumber(bonusNumber);
            validateDrawResults(drawResults);
    }

    private void validateDrawResults(DrawResults drawResults) {
        Integer mainSize = drawResults.getMainSize();
        Integer bonusSize = drawResults.getBonusSize();

        if (!Objects.equals(mainSize, bonusSize)) {

        }
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
