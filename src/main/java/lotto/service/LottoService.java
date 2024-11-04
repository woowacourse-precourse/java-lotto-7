package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;
import lotto.model.Lotto;

import java.util.*;

public class LottoService {
    private final int PERCENT_MULTIPLIER = 100;
    private final List<Integer> winningNumbers;
    private final int winningBonusNumber;
    private final String MATCH_3 = "3개 일치 (5,000원)";
    private final String MATCH_4 = "4개 일치 (50,000원)";
    private final String MATCH_5 = "5개 일치 (1,500,000원)";
    private final String MATCH_5_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private final String MATCH_6 = "6개 일치 (2,000,000,000원)";

    public LottoService(List<Integer> winningNumbers, int winningBonusNumber) {
        this.winningNumbers = winningNumbers;
        this.winningBonusNumber = winningBonusNumber;
    }

    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO_NUMBER.getValue(),
                LottoConstant.MAX_LOTTO_NUMBER.getValue(),
                LottoConstant.LOTTO_NUMBERS_LENGTH.getValue());
        List<Integer> lottoNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public LinkedHashMap<String, Integer> calculateUserLottoStatistics(List<Lotto> userLottos) {
        LinkedHashMap<String, Integer> userLottoStatistics = new LinkedHashMap<>();
        userLottoStatistics.put(MATCH_3, 0);
        userLottoStatistics.put(MATCH_4, 0);
        userLottoStatistics.put(MATCH_5, 0);
        userLottoStatistics.put(MATCH_5_WITH_BONUS, 0);
        userLottoStatistics.put(MATCH_6, 0);

        for (Lotto lotto : userLottos) {
            int matchCounts = countMatchCounts(lotto.getNumbers());
            boolean matchBonusNumber = lotto.getNumbers().contains(winningBonusNumber);

            updateStatistics(userLottoStatistics, matchCounts, matchBonusNumber);
        }

        return userLottoStatistics;
    }

    public double calculateRateOfReturn(LinkedHashMap<String, Integer> userLottoStatistics, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(userLottoStatistics);

        return (double) totalPrize / purchaseAmount * PERCENT_MULTIPLIER;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }

    private int calculateTotalPrize(LinkedHashMap<String, Integer> userLottoStatistics) {
        Map<String, Integer> prizeMoney = new HashMap<>();
        prizeMoney.put(MATCH_3, 5000);
        prizeMoney.put(MATCH_4, 50000);
        prizeMoney.put(MATCH_5, 1500000);
        prizeMoney.put(MATCH_5_WITH_BONUS, 30000000);
        prizeMoney.put(MATCH_6, 2000000000);

        int totalPrize = 0;
        for (Map.Entry<String, Integer> entry : userLottoStatistics.entrySet()) {
            String prizeGrade = entry.getKey();
            int count = entry.getValue();
            totalPrize += prizeMoney.getOrDefault(prizeGrade, 0) * count;
        }
        return totalPrize;
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
                   MATCH_6,
                    userLottoStatistics.get(MATCH_6) + 1);
            return;
        }
        if (matchCounts == 5 && matchBonusNumber) {
            userLottoStatistics.put(
                    MATCH_5_WITH_BONUS,
                    userLottoStatistics.get(MATCH_5_WITH_BONUS) + 1);
            return;
        }
        if (matchCounts == 5) {
            userLottoStatistics.put(
                    MATCH_5,
                    userLottoStatistics.get(MATCH_5) + 1);
            return;
        }
        if (matchCounts == 4) {
            userLottoStatistics.put(
                    MATCH_4,
                    userLottoStatistics.get(MATCH_4) + 1);
            return;
        }
        if (matchCounts == 3) {
            userLottoStatistics.put(
                    MATCH_3,
                    userLottoStatistics.get(MATCH_3) + 1);
        }
    }
}
