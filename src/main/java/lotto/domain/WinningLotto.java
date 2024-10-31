package lotto.domain;

import static lotto.common.Constants.LOTTO_NUMBER_MAX;
import static lotto.common.Constants.LOTTO_NUMBER_MIN;

import java.util.List;
import lotto.common.LottoRank;

public class WinningLotto {
    private static final int BONUS_NUMBER_MAX = LOTTO_NUMBER_MAX;
    private static final int BONUS_NUMBER_MIN = LOTTO_NUMBER_MIN;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = Lotto.create(winningNumbers);
        validate(bonusNumber, this.winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < BONUS_NUMBER_MIN || bonusNumber > BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoRank determineRank(Lotto userTicket) {
        int matchCount = userTicket.matchCount(winningLotto);
        boolean bonusMatch = userTicket.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, bonusMatch);
    }
}
