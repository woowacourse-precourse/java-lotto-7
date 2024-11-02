package lotto.lotto;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWiningNumbers {

    private final WiningNumbers winingNumbers;
    private final LottoNumber bonusNumber;

    public LottoWiningNumbers(WiningNumbers winingNumbers, LottoNumber bonusNumber) {
        validate(winingNumbers, bonusNumber);
        this.winingNumbers = winingNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> matchAll(Lottos lottos) {
        Map<Rank, Integer> rankSummary = Rank.initializeRankSummary();

        List<Lotto> LottoValue = lottos.getLottos();
        for (Lotto lotto : LottoValue) {
            Rank rank = match(lotto);
            rankSummary.put(rank, rankSummary.get(rank) + 1);
        }
        return sortRankSummaryByAmount(rankSummary);
    }

    private void validate(WiningNumbers winingNumbers, LottoNumber bonusNumber) {
        if (winingNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private Rank match(Lotto lotto) {
        int countOfMatch = winingNumbers.countOfMatch(lotto);
        boolean matchBonus = winingNumbers.contains(bonusNumber);
        return Rank.determine(countOfMatch, matchBonus);
    }

    private LinkedHashMap<Rank, Integer> sortRankSummaryByAmount(Map<Rank, Integer> rankSummary) {
        return rankSummary.keySet().stream()
                .sorted(Comparator.comparing(Rank::getAmount))
                .collect(Collectors.toMap(rank -> rank, rankSummary::get, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }
}
