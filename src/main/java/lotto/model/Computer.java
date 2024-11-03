package lotto.model;

import java.util.List;

public class Computer {
    private final Lotto winningLotto;
    private int bonusNumber;

    public Computer(List<Integer> winningNumbers) {
        this.winningLotto = new Lotto(winningNumbers);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void compareLotto(List<Lotto> lotto) {
        for (Lotto oneOfLotto : lotto) {
            int correctCount = getCorrectCount(oneOfLotto);
            boolean hasBonus = hasBonus(oneOfLotto);
        }
    }

    public int getCorrectCount(Lotto lotto) {
        int correctCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                correctCount += 1;
            }
        }
        return correctCount;
    }

    public boolean hasBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
