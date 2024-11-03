package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class DrawingLotto {
    private final List<Integer> drawingNumbers;

    // 1~45범위의 6자리 수를 생성하여 로또 번호를 자동 생성
    public DrawingLotto() {
        this.drawingNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getDrawingNumbers() {
        return this.drawingNumbers;
    }
}
