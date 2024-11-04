package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> compareWithWinLotto(WinningNumbers winningNumbers) {
        List<Integer> winNumbers = winningNumbers.getWinLottoNumbers();
        return lottos.stream()
                .map(lotto -> determineRank(lotto, winNumbers, winningNumbers.getBonusNumber()))
                .collect(Collectors.toList());
    }

    private Rank determineRank(Lotto lotto, List<Integer> winNumbers, Integer bonus) {
        Integer matched = lotto.compareWithWinLotto(winNumbers);

        if (matched != 5) {
            return Rank.valueOf(matched, false);
        }

        boolean hasBonus = lotto.getNumbers().contains(bonus);
        return Rank.valueOf(matched, hasBonus);
    }
}
