package lotto.drawsystem;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class DrawMachine {

    DrawResults drawResults;

    public DrawResults runDraws(Integer amount) {
        DrawMachine drawMachine = new DrawMachine();
        for (int drawCount = 0; drawCount < amount; amount++) {
            runSingleDraw();
        }
        return drawResults;
    }


    public void runSingleDraw() {

        List<Integer> mainNumbers = drawMainNumbers();
        Integer bonusNumber = drawBonusNumber(mainNumbers);
        drawResults.addMainNumbers(mainNumbers);
        drawResults.addBonusNumber(bonusNumber);
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
