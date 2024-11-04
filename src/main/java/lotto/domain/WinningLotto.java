package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private static WinningLotto winningLottoInstance;
    private final int bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        new ValidatorLottoNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto getWinningLotto() {
        if (winningLottoInstance == null) throw new IllegalArgumentException("[ERROR] 싱글톤 객체가 생성되기 전에 불렀습니다.");
        return winningLottoInstance;
    }

    public static WinningLotto getWinningLotto(List<Integer> numbers, int bonusNumber) {
        if (winningLottoInstance == null) winningLottoInstance = new WinningLotto(numbers, bonusNumber);
        return winningLottoInstance;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static void resetInstance() {
        if ("true".equals(System.getProperty("IS_TEST_ENV"))) {
            winningLottoInstance = null;
        }
    }
}
