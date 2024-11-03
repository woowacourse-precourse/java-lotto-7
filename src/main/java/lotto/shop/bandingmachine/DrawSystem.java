package lotto.shop.bandingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.MessageCenter;

public class DrawSystem {

    DrawnNumbers drawnNumbers;
    List<DrawnNumbers> drawnNumberPacks = new ArrayList<>();

    DrawSystem(DrawnNumbers drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    static DrawSystem forTest(DrawnNumbers drawnNumbers) {
        return new DrawSystem(drawnNumbers);
    }

    List<DrawnNumbers> runDraws(Integer totalCount) {
        validateTotalCount(totalCount);
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

    private void validateTotalCount(Integer totalCount) {
        validatePositive(totalCount);
        validateNull(totalCount);
    }

    private void validatePositive(Integer totalCount) {
        if (totalCount <= 0) {
            throw new IllegalArgumentException(MessageCenter.ERROR_COUNT.get());
        }
    }

    private void validateNull(Integer totalCount) {
        if (totalCount == null) {
            throw new IllegalArgumentException(MessageCenter.ERROR_COUNT.get());
        }
    }
}
