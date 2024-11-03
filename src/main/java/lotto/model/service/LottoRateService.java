package lotto.model.service;

import lotto.model.domain.*;

import java.util.List;

public class LottoRateService {

    private Rate rate;

    public Rate calculateRate(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonus) {
        rate = new Rate();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> winningLottoNumbers = winningNumbers.getWinningNumbers();
            int bounsNumber = bonus.getBonusNumber();

            int matchCount = (int) lottoNumbers.stream()
                    .filter(winningLottoNumbers::contains)
                    .count();
            updateRateStatus(matchCount, lottoNumbers, bounsNumber);
        }

        return rate;
    }

    private void updateRateStatus(int matchCount, List<Integer> lottoNumbers, int bonusNumber) {
        if (matchCount == 3) {
            rate.updateMatchStatus("three_match");
        }
        if (matchCount == 4) {
            rate.updateMatchStatus("four_match");
        }
        if (matchCount == 5) {
            if (lottoNumbers.contains(bonusNumber)) {
                // 보너스 번호도 일치
                rate.updateMatchStatus("five_bonus_match");
            }
            if (!lottoNumbers.contains(bonusNumber)) {
                // 보너스 번호 일치하지 않음
                rate.updateMatchStatus("five_match");
            }
        }
        if (matchCount == 6) {
            rate.updateMatchStatus("six_match");
        }
    }
}
