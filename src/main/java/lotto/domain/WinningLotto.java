package lotto.domain;

import static lotto.MessageContainer.OUT_OF_RANGE_NUMBER_ERROR;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final int bonusNumber;

    public WinningLotto(LottoTicket winningTicket, int bonusNumber) {
        this.winningTicket = winningTicket;
        validateRangeOf(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Winning checkWinningWith(Lotto issuedLotto) {
        boolean withBonusNumber = containsBonusNumber(issuedLotto);
        int totalMatches = countMatchingNumbersWith(issuedLotto);
        return Winning.tellWinningBy(totalMatches, withBonusNumber);
    }

    public boolean containsBonusNumber(Lotto issuedLotto) {
        return issuedLotto.contains(bonusNumber);
    }

    public int countMatchingNumbersWith(Lotto issuedLotto) {
        Lotto winningLotto = winningTicket.lottos().getFirst();
        return winningLotto.countMatchingNumbersWith(issuedLotto);
    }

    private void validateRangeOf(int number) {
        if (!verifyInLottoNumberRange(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR);
        }
    }

    private boolean verifyInLottoNumberRange(Integer number) {
        return (number >= MIN_LOTTO_NUMBER) && (number <= MAX_LOTTO_NUMBER);
    }
}
