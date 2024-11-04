package lotto.model.service;

import lotto.model.domain.*;

import java.util.List;

public class LottoResultService {

    private LottoResult lottoResult;

    public LottoResult calculateRate(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonus) {
        lottoResult = new LottoResult();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> winningLottoNumbers = winningNumbers.getWinningNumbers();
            int bounsNumber = bonus.getBonusNumber();

            int matchCount = (int) lottoNumbers.stream()
                    .filter(winningLottoNumbers::contains)
                    .count();

            updateRateStatus(matchCount, lottoNumbers, bounsNumber);
        }
        return lottoResult;
    }

    private void updateRateStatus(int matchCount, List<Integer> lottoNumbers, int bonusNumber) {
        if (matchCount == 3) {
            lottoResult.updateMatchStatus("three_match");
        }
        if (matchCount == 4) {
            lottoResult.updateMatchStatus("four_match");
        }
        if (matchCount == 5) {
            if (lottoNumbers.contains(bonusNumber)) {
                lottoResult.updateMatchStatus("five_bonus_match");
            }
            if (!lottoNumbers.contains(bonusNumber)) {
                lottoResult.updateMatchStatus("five_match");
            }
        }
        if (matchCount == 6) {
            lottoResult.updateMatchStatus("six_match");
        }
    }

    public double caculateRateReturn(LottoResult lottoResult, Money money) {
        int totalPirze = lottoResult.getTotalPrize();
        int amount = money.getAmount();
        double rateReturn = (double) totalPirze / amount;
        return rateReturn * 100;
    }
}
