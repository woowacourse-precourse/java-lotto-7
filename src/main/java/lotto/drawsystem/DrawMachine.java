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
        return DrawResults;
    }


    public void runSingleDraw() {

        drawMainNumbers();
        drawBonusNumber();

    }

    private List<Integer> drawMainNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Integer drawBonusNumber() {

    }


}
