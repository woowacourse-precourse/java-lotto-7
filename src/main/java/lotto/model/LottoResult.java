package lotto.model;

import lotto.domain.Lotto;
import lotto.policy.RankingPolicy;

import java.util.*;

public class LottoResult {
    private final List<Lotto> lottoList;
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<RankingPolicy, Integer> resultMap;

    public LottoResult(List<Lotto> lottoList, Set<Integer> winningNumbers, int bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.resultMap = initResultMap();
    }

    public static LottoResult create(List<Lotto> lottoNumbers, Set<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(lottoNumbers, winningNumbers, bonusNumber);
    }

    public Map<RankingPolicy, Integer> calculateResults() {
        Map<RankingPolicy, Integer> resultMap = initResultMap();

        this.lottoList.forEach(lotto -> {
            RankingPolicy policy = evaluateLotto(lotto);
            if (policy != RankingPolicy.MATCH_NONE) {
                resultMap.merge(policy, 1, Integer::sum);
            }
        });

        return resultMap;
    }
    private RankingPolicy evaluateLotto(Lotto lotto) {
        Set<Integer> lottoNumbers = lotto.getNumbers();
        lottoNumbers.retainAll(winningNumbers);

        int matchCount = lottoNumbers.size();
        boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);

        return RankingPolicy.getPolicy(matchCount, bonusMatch);
    }

    private Map<RankingPolicy, Integer> initResultMap() {
        return Arrays.stream(RankingPolicy.values())
                .filter(policy -> policy != RankingPolicy.MATCH_NONE)
                .collect(HashMap::new,
                        (map, policy) -> map.put(policy, 0),
                        HashMap::putAll);
    }
}
