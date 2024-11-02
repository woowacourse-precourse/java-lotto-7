package lotto.service;

import static lotto.CommonSymbols.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;

public class LottoService {
    public List<Lotto> generateLottos(String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);

        int lottoCount = parsedPurchaseAmount / 1000;

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    public String getFormattedLottoNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::formattedNumbers)
                .collect(Collectors.joining(NEW_LINE.getSymbol()));
    }

    public Map<Integer, Integer> winningDetermination(List<Integer> winningNumbers, int bonusNumber,
                                                      List<Lotto> lottos) {
        Map<Integer, Integer> matchCounts = new HashMap<>();

        for (int count = 3; count <= 6; count++) {
            matchCounts.put(count, 0);
        }
        matchCounts.put(-5, 0); //5개 + 보너스

        lottos.stream()
                .forEach(lotto -> {
                    int matchCount = lotto.countMatchingNumbers(winningNumbers);
                    boolean isBonusMatch = lotto.containsBonusNumber(bonusNumber);
                    if (matchCount == 5 && isBonusMatch) {
                        matchCounts.put(-5, matchCounts.get(-5) + 1);
                        return;
                    }
                    if (matchCount == 5) {
                        matchCounts.put(3, matchCounts.get(3) + 1);
                        return;
                    }
                    if (matchCount >= 3) {
                        matchCounts.put(matchCount, matchCounts.get(matchCount) + 1);
                    }
                });
        return matchCounts;
    }
}
