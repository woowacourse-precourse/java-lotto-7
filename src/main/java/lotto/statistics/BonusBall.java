package lotto.statistics;

import java.util.List;

public class BonusBall {

    private final int number;

    public BonusBall(int number) {
        checkLottoRange(number);
        this.number = number;
    }

    public boolean matchBonus(List<Integer> myLotto) {
        return myLotto.contains(number);
    }

    private void checkLottoRange(int number) {
        if (!LottoBall.isInRange(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45만 가능합니다.");
        }
    }
}
