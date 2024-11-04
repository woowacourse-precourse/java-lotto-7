package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public class WinningDraw {

    private final Lotto winningLotto;
    private final LottoBall bonusBall;

    private WinningDraw(final Lotto winningLotto, final LottoBall bonusBall) {
        validateBonusNumberDuplication(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningDraw draw(final Lotto winningLotto, final LottoBall bonusBall) {
        return new WinningDraw(winningLotto, bonusBall);
    }

    public LottoRank compareWithWinningLotto(final Lotto lotto) {
        int matchingCount = winningLotto.calculateMatchingCount(lotto);
        boolean hasBonusNumber = lotto.has(bonusBall);

        return LottoRank.find(matchingCount, hasBonusNumber);
    }

    public static void validateBonusNumberDuplication(final Lotto winningLotto, final LottoBall bonusNumber) {
        if (winningLotto.has(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복되면 안됩니다.");
        }
    }

}
