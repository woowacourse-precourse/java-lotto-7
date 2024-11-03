package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Result;
import lotto.util.WinningRank;

public class ResultJudging {

    public Result lottoResult(List<Integer> allLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Result result = new Result(); // 6개씩 끊어서 각 티켓을 확인

        for (int i = 0; i < allLottoNumbers.size(); i += 6) {
            Set<Integer> ticket = new HashSet<>(allLottoNumbers.subList(i, i + 6));
            int matchCount = 0;
            boolean hasBonus = false;

            // 당첨 번호와 몇 개 일치하는지 확인
            for (int number : ticket) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
                if (number == bonusNumber) {
                    hasBonus = true;
                }
            }

            result.updateStatistics(WinningRank.getRank(matchCount, hasBonus));
        }
        return result; // 결과 반환
    }

    public double returnRate(int price, Result result) {
        return ((double) ((result.getThreeCount() * 5000) + (result.getFourCount() * 50000)
                + (result.getFiveCount() * 1500000) + (result.getBonusCount() * 30000000)
                + (result.getSixCount() * 2000000000)) / price);
    }
}
