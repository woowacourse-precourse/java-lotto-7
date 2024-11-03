package lotto.domain;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final int bonusNumber;

    public WinningLotto(LottoTicket winningTicket, int bonusNumber) {
        this.winningTicket = winningTicket;
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
}
