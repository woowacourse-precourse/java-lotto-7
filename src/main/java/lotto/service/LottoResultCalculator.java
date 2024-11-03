package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class LottoResultCalculator {
    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;
    private LottoTicket lottoTicket;
    private List<LottoRank> winningLottos;

    public LottoResultCalculator(Lotto winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningLottos = new ArrayList<>();
    }

    public void inputLottoTicket(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public void run() {
        List<Lotto> lottos = this.lottoTicket.getLottos();
        for (Lotto lotto : lottos) {
            LottoRank lottoResult = checkWinning(lotto);
            if (lottoResult != null) {
                this.winningLottos.add(lottoResult);
            }
        }
    }

    private LottoRank checkWinning(Lotto lotto) {
        int matchCount = matchingWinningNumberCount(lotto);
        boolean matchBonus = matchBonusNumber(lotto);
        return LottoRank.findRank(matchCount, matchBonus);
    }

    private int matchingWinningNumberCount(Lotto lotto) {
        int matchCount = 0;
        for (int winningNumber : winningNumber.getNumbers()) {
            if (lotto.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber.getValue());
    }
}
