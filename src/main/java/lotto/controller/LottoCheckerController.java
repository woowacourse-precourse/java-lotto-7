package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoResultDTO;
import lotto.dto.WinningLottoDTO;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoPurchasedInfo;

public class LottoCheckerController {

    private LottoPurchasedInfo lottoPurchasedInfo;

    public void setPurchasedLotto(List<Lotto> purchased, Long totalCost) {
        lottoPurchasedInfo = new LottoPurchasedInfo(purchased, totalCost);
    }

    public LottoResultDTO checkPurchasedLottoRank(WinningLottoDTO winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumber();
        Integer bonusNumber = winningLotto.getBonusNumber();

        Map<LottoRank, Long> countResult = lottoPurchasedInfo.getWinningResult(winningNumbers, bonusNumber);
        Double profitPercentage = lottoPurchasedInfo.calculateProfitPercentage();

        return new LottoResultDTO(countResult, profitPercentage);
    }
}
