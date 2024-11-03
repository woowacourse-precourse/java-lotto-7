package lotto.domain;

public class WinningLotto {

    private final Lotto winninglotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winninglotto, int bonusNumber) {
        this.winninglotto = winninglotto;
        this.bonusNumber = bonusNumber;
    }

    public int checkRank(Lotto lotto) {

        long matchCount = lotto.getNumbers().stream()
                .filter(winninglotto.getNumbers()::contains)
                .count();

        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }
}
