package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.controller.LottoNumberGenerator;

public class LottoService {
    private Map<String, Integer> matchResults;
    private final int lottoSetCount;
    private List<List<Integer>> lottoSets;

    public LottoService(int lottoMoney) {
        this.lottoSetCount = calculateLottoSetCount(lottoMoney);
        initializeMatchResults();
    }

    private void initializeMatchResults() {
        matchResults = new HashMap<>();
        matchResults.put("3", 0);
        matchResults.put("4", 0);
        matchResults.put("5", 0);
        matchResults.put("5+Bonus", 0);
        matchResults.put("6", 0);
    }

    public void generateLottoSet() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        lottoSets = generator.generateLottoSet(lottoSetCount);
    }

    public List<List<Integer>> getLottoSets() {
        return lottoSets;
    }

    public void compareWinningNumbers(List<List<Integer>> lottoSets, List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);

        for (List<Integer> lottoNumber : lottoSets) {
            int matchCount = lotto.countMatchingNumbers(lottoNumber);
            boolean bonusMatch = lotto.containsBonusNumber(bonusNumber, lottoNumber);
            updateMatchResults(matchCount, bonusMatch);
        }
    }

    public Map<String, Integer> getMatchResults() {
        return matchResults;
    }

    private void updateMatchResults(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            matchResults.put("5+Bonus", matchResults.get("5+Bonus") + 1);
        } else if (matchCount >= 3) {
            matchResults.put(matchCount + "", matchResults.get(matchCount + "") + 1);
        }
    }

    private int calculateLottoSetCount(int lottoMoney) {
        return lottoMoney / 1000;
    }
}
