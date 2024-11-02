package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.util.RandomNumbers;

public class Lottos {

    private List<Lotto> lottos;
    private final int lottoCount;
    private final List<Integer> winningNumbers;
    private Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
    private final int bonusNumber;

    public Lottos(int purchaseAmount,List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = new ArrayList<>();
        this.lottoCount = purchaseAmount / 1000;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto createLotto() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();
        Lotto lotto = new Lotto(numbers);
        lotto.sortNumbers(lotto.getNumbers());
        return lotto;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public void calculateWinningStatistics(List<Lotto> lottos) {
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            LottoRank rank = calculateRank(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }
    }

    private LottoRank calculateRank(Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;
        int prize = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                matchBonus = true;
            }
        }
        return LottoRank.valueOf(matchCount, matchBonus);
    }
}
