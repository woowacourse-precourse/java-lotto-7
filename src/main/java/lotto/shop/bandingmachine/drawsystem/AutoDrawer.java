package lotto.shop.bandingmachine.drawsystem;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.shop.bandingmachine.TrialHistory;

public class AutoDrawer {

    DrawnNumbers drawnNumbers;
    List<DrawnNumbers> drawnNumberPacks = new ArrayList<>();

    AutoDrawer(DrawnNumbers drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    static AutoDrawer forTest(DrawnNumbers drawnNumbers) {
        return new AutoDrawer(drawnNumbers);
    }

    List<DrawnNumbers> runDraws(Integer totalCount) {
        for (int currentCount = 0; currentCount < totalCount; currentCount++) {
            drawnNumbers = DrawnNumbers.create();
            runDraw();
            drawnNumberPacks.add(drawnNumbers);
        }
        return drawnNumberPacks;
    }

    void runDraw() {
        List<Integer> mainNumbers = drawMainNumbers();
        Integer bonusNumber = drawBonusNumber(mainNumbers);
        addDrawResult(mainNumbers, bonusNumber);
    }

    private void addDrawResult(List<Integer> mainNumbers, Integer bonusNumber) {
            drawnNumbers.addMainNumbers(mainNumbers);
            drawnNumbers.addBonusNumber(bonusNumber);
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
        while (result) {
            bonusNumber = initBonusNumber();
            result = isBonusNumberAlready(mainNumbers, bonusNumber);
        }
        return bonusNumber;
    }

    private boolean isBonusNumberAlready(List<Integer> mainNumbers, Integer bonusNumber) {
        return mainNumbers.contains(bonusNumber);
    }
}
