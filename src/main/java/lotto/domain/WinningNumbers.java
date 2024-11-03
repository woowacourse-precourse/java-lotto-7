package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private static WinningNumbers instance;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        if(winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers getInstance(List<Integer> numbers, int bonusNumber) {
        if (instance == null) {
            instance = new WinningNumbers(numbers, bonusNumber);
        }
        return instance;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
