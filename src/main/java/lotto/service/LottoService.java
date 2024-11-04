package lotto.service;

import lotto.domain.LottoMatchType;
import lotto.util.LottoNumberGenerator;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int AMOUNT_UNIT = 1000;
    private static final int WINNING_MINIMUM_MATCH_COUNTS = 3;
    private static final int WINNING_BONUS_MATCH_COUNTS = 5;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int getLottoCount(int purchasePrice) {
        return purchasePrice / AMOUNT_UNIT;
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoNumberGenerator.generateLottos(amount);
    }

    public Map<LottoMatchType, Integer> getMatchResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoMatchType, Integer> matchResult = new EnumMap<>(LottoMatchType.class);
        initializeResult(matchResult);
        lottos.stream()
                .map(lotto -> getLottoMatchResult(lotto, winningNumbers, bonusNumber))
                .filter(lottoMatchType -> lottoMatchType != LottoMatchType.NONE)
                .forEach(lottoMatchType -> matchResult.put(lottoMatchType, matchResult.get(lottoMatchType) + 1));
        return matchResult;
    }

    private void initializeResult(Map<LottoMatchType, Integer> matchResult) {
        Arrays.stream(LottoMatchType.values())
                .forEach(lottoMatchType -> matchResult.put(lottoMatchType, 0));
    }

    private LottoMatchType getLottoMatchResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                                            .filter(winningNumbers::contains)
                                            .count();
        if (matchCount < WINNING_MINIMUM_MATCH_COUNTS) {
            return LottoMatchType.NONE;
        }
        boolean bonus = hasBonus(matchCount, lotto, bonusNumber);
        return LottoMatchType.getType(matchCount, bonus);
    }

    private boolean hasBonus(int matchCount, Lotto lotto, int bonusNumber) {
        if (matchCount == WINNING_BONUS_MATCH_COUNTS) {
            return lotto.getNumbers().contains(bonusNumber);
        }
        return false;
    }

    public double getProfitRate(Map<LottoMatchType, Integer> matchResult, int purchasePrice) {
        long sum = matchResult.keySet()
                .stream()
                .mapToLong(lottoMatchType -> lottoMatchType.getProfit(matchResult.get(lottoMatchType)))
                .sum();
        return (double) sum / purchasePrice * 100;
    }
}
