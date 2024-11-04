package lotto.service;

import lotto.model.Lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.LottoMatchConstant.*;

public class LottoStatistics {
    private final List<Integer> winningNumbers;
    private final int winningBonusNumber;

    public LottoStatistics(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public LinkedHashMap<String, Integer> calculateUserLottoStatistics(List<Lotto> userLottos) {
        LinkedHashMap<String, Integer> userLottoStatistics = new LinkedHashMap<>();
        userLottoStatistics.put(MATCH_3.getMatch(), 0);
        userLottoStatistics.put(MATCH_4.getMatch(), 0);
        userLottoStatistics.put(MATCH_5.getMatch(), 0);
        userLottoStatistics.put(MATCH_5_WITH_BONUS.getMatch(), 0);
        userLottoStatistics.put(MATCH_6.getMatch(), 0);

        for (Lotto lotto : userLottos) {
            int matchCounts = countMatchCounts(lotto.getNumbers());
            boolean matchBonusNumber = lotto.getNumbers().contains(winningBonusNumber);

            updateStatistics(userLottoStatistics, matchCounts, matchBonusNumber);
        }

        return userLottoStatistics;
    }

    private int countMatchCounts(List<Integer> userLottoNumbers) {
        int count = 0;
        for (Integer userNumber : userLottoNumbers) {
            if (winningNumbers.contains(userNumber)) {
                count++;
            }
        }
        return count;
    }

    private void updateStatistics(Map<String, Integer> userLottoStatistics, int matchCounts, boolean matchBonusNumber) {
        if (matchCounts == 6) {
            userLottoStatistics.put(
                    MATCH_6.getMatch(),
                    userLottoStatistics.get(MATCH_6.getMatch()) + 1);
            return;
        }
        if (matchCounts == 5 && matchBonusNumber) {
            userLottoStatistics.put(
                    MATCH_5_WITH_BONUS.getMatch(),
                    userLottoStatistics.get(MATCH_5_WITH_BONUS.getMatch()) + 1);
            return;
        }
        if (matchCounts == 5) {
            userLottoStatistics.put(
                    MATCH_5.getMatch(),
                    userLottoStatistics.get(MATCH_5.getMatch()) + 1);
            return;
        }
        if (matchCounts == 4) {
            userLottoStatistics.put(
                    MATCH_4.getMatch(),
                    userLottoStatistics.get(MATCH_4.getMatch()) + 1);
            return;
        }
        if (matchCounts == 3) {
            userLottoStatistics.put(
                    MATCH_3.getMatch(),
                    userLottoStatistics.get(MATCH_3.getMatch()) + 1);
        }
    }
}
