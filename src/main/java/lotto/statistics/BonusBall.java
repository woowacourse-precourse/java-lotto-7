package lotto.statistics;

import java.util.List;

public class BonusBall {

    private final int number;

    public BonusBall(int number, List<Integer> winningLotto) {
        checkLottoRange(number);
        checkDuplicateWinningLotto(number, winningLotto);
        this.number = number;
    }

    public boolean matchBonus(List<Integer> lotto) {
        return lotto.contains(number);
    }

    private boolean matchBonus(int number, List<Integer> lotto) {
        return lotto.contains(number);
    }

    private void checkLottoRange(int number) {
        if (!LottoBall.isInRange(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45만 가능합니다.");
        }
    }

    private void checkDuplicateWinningLotto(int number, List<Integer> winningLotto) {
        if (matchBonus(number, winningLotto)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
