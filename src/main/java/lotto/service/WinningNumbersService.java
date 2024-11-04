package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

import java.util.List;

public class WinningNumbersService {
    public WinningNumbers getWinningNumbers (String inputWinningNumbers) {
        return new WinningNumbers(inputWinningNumbers);
    }

    public void getBonusNumber(WinningNumbers winningNumbers, String rawBonusNumber) {
        winningNumbers.addBonusNumber(rawBonusNumber);
    }

    public List<LottoRank> getLottoRanks (Lottos lottos, WinningNumbers winningNumbers) {
        return winningNumbers.getLottoRanks(lottos);
    }

}
