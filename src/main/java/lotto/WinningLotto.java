package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45 ) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복되지 않은 숫자여야 합니다.");
        }
    }

    public LottoRank match(Lotto userLotto) {
        int matchCount = winningNumbers.matchCount(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }
}
