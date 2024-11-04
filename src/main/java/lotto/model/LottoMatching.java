package lotto.model;

public class LottoMatching {

    private final Lotto userLotto;
    private final WinningLotto winningLotto;
    private final int matchCount;
    private final boolean matchBonus;

    public LottoMatching(Lotto userLotto, WinningLotto winningLotto) {
        this.userLotto = userLotto;
        this.winningLotto = winningLotto;
        this.matchCount = checkMatchCount();
        this.matchBonus = checkBonus();
    }

    private int checkMatchCount() {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto.winningLotto().getNumbers()::contains)
                .count();
    }

    private boolean checkBonus() {
        return userLotto.getNumbers().contains(winningLotto.bonusNumber());
    }

    public LottoPrize getLottoPrize() {
        return LottoPrize.of(matchCount, matchBonus);
    }

}
