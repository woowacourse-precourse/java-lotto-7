package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.message.info.InfoMessage;

import java.math.BigDecimal;
import java.util.*;

public class LottServiceImpl implements LottoService {

    private static final String FIRST = InfoMessage.FIRST.getMessage();
    private static final String SECOND = InfoMessage.SECOND.getMessage();
    private static final String THIRD = InfoMessage.THIRD.getMessage();
    private static final String FOURTH = InfoMessage.FOURTH.getMessage();
    private static final String FIFTH = InfoMessage.FIFTH.getMessage();

    @Override
    public int calculateLottoCount(int amount) {
        return amount / 1000;
    }

    @Override
    public List<Integer> extractWinningNumbersFromString(String str) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : str.split(",")) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    @Override
    public List<List<Integer>> lottoNumbers(int cnt) {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            lottoNumbersList.add(lottoNumber);
        }

        return lottoNumbersList;
    }

    @Override
    public Map<String, Integer> calculateWinningStatistics(List<List<Integer>> purchasedLotto, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> matchCounts = new LinkedHashMap<>();
        matchCounts.put(FIFTH, 0);
        matchCounts.put(FOURTH, 0);
        matchCounts.put(THIRD, 0);
        matchCounts.put(SECOND, 0);
        matchCounts.put(FIRST, 0);

        for (List<Integer> lotto : purchasedLotto) {
            int matchCount = calculateMatchCount(lotto, winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);

            if (matchCount == 6) {
                matchCounts.put(FIRST, matchCounts.get(FIRST) + 1);
            } else if (matchCount == 5 && bonusMatch) {
                matchCounts.put(SECOND, matchCounts.get(SECOND) + 1);
            } else if (matchCount == 5 && !bonusMatch) {
                matchCounts.put(THIRD, matchCounts.get(THIRD) + 1);
            } else if (matchCount == 4) {
                matchCounts.put(FOURTH, matchCounts.get(FOURTH) + 1);
            } else if (matchCount == 3) {
                matchCounts.put(FIFTH, matchCounts.get(FIFTH) + 1);
            }
        }

        return matchCounts;
    }

    @Override
    public double calculateYield(Long totalPrize, int purchaseAmount) {
        if (purchaseAmount == 0) return 0;
        double yield = ((double) totalPrize / purchaseAmount) * 100;
        return roundToTwoDecimalPlaces(yield);
    }

    @Override
    public Long calculateTotalPrize(Map<String, Integer> matchCounts) {
        long totalPrize = 0;
        totalPrize += matchCounts.get(FIFTH) * 5000;
        totalPrize += matchCounts.get(FOURTH) * 50000;
        totalPrize += matchCounts.get(THIRD) * 1500000;
        totalPrize += matchCounts.get(SECOND) * 30000000;
        totalPrize += matchCounts.get(FIRST) * 200000000;

        return totalPrize;
    }

    private int calculateMatchCount(List<Integer> lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 10.0) / 10.0;
    }
}
