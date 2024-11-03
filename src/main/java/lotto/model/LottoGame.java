package lotto.model;

import lotto.dto.WinningLottoDto;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private PurchasedLottos purchasedLottos;
    private WinningNumbers winningNumbers;
    private int bonusNumber;
    private LottoResult lottoResult;

    public LottoGame(PurchasedLottos purchasedLottos, WinningNumbers winningNumbers, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoResult = new LottoResult();
    }

    public void process() {
        List<WinningLottoDto> winningLottoDtos = this.purchasedLottos.calculateLottoResult(
                this.winningNumbers.getWinningNumbers(), this.bonusNumber);

        winningLottoDtos.forEach(dto ->
                lottoResult.increaseCountByNumberMatchedAndBonusMatched(
                        (int) dto.getMatchedCount(), dto.getIsBonusMatched()));
    }

    public Map<String, Integer> getLottoMatchedCount() {
        return this.lottoResult.getMatchedCount();
    }
}
