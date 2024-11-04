package lotto.domain;

import static lotto.domain.LottosResult.*;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NO_RANK;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(lottos);
    }

    public LottosResult getResult(Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> resultRepository = new HashMap<>(Map.of(
                FIRST.getName(), 0, SECOND.getName(),0, THIRD.getName(), 0,
                FOURTH.getName(),0, FIFTH.getName(),0 , NO_RANK.getName(), 0,
                TOTAL_PRIZE,0,PURCHASE_AMOUNT,0));

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean isMatchBonus = lotto.isContain(bonusNumber);
            Rank rank = determineLottoRank(matchCount,isMatchBonus);

            resultRepository.computeIfPresent(rank.getName(), (key,value)-> value+1);
        }
        resultRepository.put(TOTAL_PRIZE, getTotalPrizeMoney(resultRepository));
        resultRepository.put(PURCHASE_AMOUNT, lottos.size() * Lotto.LOTTO_PRICE);

        return new LottosResult(resultRepository);
    }

    private Rank determineLottoRank(int matchCount, boolean isMatchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && isMatchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NO_RANK;
    }

    private int getTotalPrizeMoney(Map<String, Integer> resultRepository) {
        int totalPrize = 0;
        totalPrize += resultRepository.get(FIRST.getName()) * FIRST.getPrizeMoney();
        totalPrize += resultRepository.get(SECOND.getName()) * SECOND.getPrizeMoney();
        totalPrize += resultRepository.get(THIRD.getName()) * THIRD.getPrizeMoney();
        totalPrize += resultRepository.get(FOURTH.getName()) * FOURTH.getPrizeMoney();
        totalPrize += resultRepository.get(FIFTH.getName()) * FIFTH.getPrizeMoney();

        return totalPrize;
    }
}
