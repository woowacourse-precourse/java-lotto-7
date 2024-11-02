package lotto.service;

import static lotto.util.RandomUtil.generateLottoNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.enums.Rank;

public class LottoService {

    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<Rank, Integer> results = new HashMap<>();

    public void generateLottos(int lottoCount) {
        IntStream.range(0, lottoCount)
                .forEach(i -> lottos.add(new Lotto(generateLottoNumbers())));
    }

    public void saveLottoRanks(List<Integer> winningNumbers, int bonusNumber) {
        lottos.forEach(lotto -> {
            int count = lotto.countMatchingNumbers(winningNumbers);
            Rank rank = Rank.getRank(count, lotto.containsBonusNumber(bonusNumber));
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        });
    }
}
