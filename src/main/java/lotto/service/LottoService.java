package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.*;

public class LottoService {
    private final List<Integer> winningNumbers;
    private final int winningBonusNumber;

    public LottoService(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

    public Map<String, Integer> calculateUserLottoStatistics(List<Lotto> userLottos) {
        LinkedHashMap<String, Integer> userLottoStatistics = new LinkedHashMap<>();
        userLottoStatistics.put("3개 일치 (5,000원)", 0);
        userLottoStatistics.put("4개 일치 (50,000원)", 0);
        userLottoStatistics.put("5개 일치 (1,500,000원)", 0);
        userLottoStatistics.put("5개 일치, 보너스 볼 일치 (30,000,000원)", 0);
        userLottoStatistics.put("6개 일치 (2,000,000,000원)", 0);

        for (Lotto lotto : userLottos) {
            int matchCounts = countMatchCounts(lotto.getNumbers());
            boolean matchBonusNumber = lotto.getNumbers().contains(winningBonusNumber);

            updateStatistics(userLottoStatistics, matchCounts, matchBonusNumber);
        }

        return userLottoStatistics;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
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
                    "6개 일치 (2,000,000,000원)",
                    userLottoStatistics.get("6개 일치 (2,000,000,000원)") + 1);
            return ;
        }
        if (matchCounts == 5 && matchBonusNumber) {
            userLottoStatistics.put(
                    "5개 일치, 보너스 볼 일치 (30,000,000원)",
                    userLottoStatistics.get("5개 일치, 보너스 볼 일치 (30,000,000원)") + 1);
            return ;
        }
        if (matchCounts == 5) {
            userLottoStatistics.put(
                    "5개 일치 (1,500,000원)",
                    userLottoStatistics.get("5개 일치 (1,500,000원)") + 1);
            return ;
        }
        if (matchCounts == 4) {
            userLottoStatistics.put(
                    "4개 일치 (50,000원)",
                    userLottoStatistics.get("4개 일치 (50,000원)") + 1);
            return ;
        }
        if (matchCounts == 3) {
            userLottoStatistics.put(
                    "3개 일치 (5,000원)",
                    userLottoStatistics.get("3개 일치 (5,000원)") + 1);
        }
    }
}
