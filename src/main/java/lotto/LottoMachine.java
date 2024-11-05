package lotto;

import java.util.List;

public class LottoMachine {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoMachine(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkTickets(List<Lotto> tickets) {
        LottoResult result = new LottoResult();
        for (Lotto ticket : tickets) {
            int matchCount = ticket.countMatchingNumbers(winningLotto);
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            result.updateResult(matchCount, bonusMatch);
        }
        return result;
    }
}
