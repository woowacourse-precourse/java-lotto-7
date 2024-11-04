package lotto.model.service;

import java.util.List;
import java.util.Map;

public interface LottoService {

    int calculateLottoCount(int amount);
    List<Integer> extractWinningNumbersFromString(String str);
    List<List<Integer>> lottoNumbers(int cnt);
    Map<String, Integer> calculateWinningStatistics(List<List<Integer>> purchasedLotto, List<Integer> winningNumbers, int bonusNumber);
    double calculateYield(Long totalPrize, int purchaseAmount);
    Long calculateTotalPrize(Map<String, Integer> matchCounts);
}
