package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    List<Lotto> list;

    public LottoList(List<Lotto> lottoList) {
        this.list = lottoList;
    }

    public List<Lotto> getLottoList() {
        return list;
    }

    public int size() {
        return list.size();
    }

    public List<Integer> getMatchCounts(List<Integer> winningNumbers, int bonusNumber) {
        return list.stream()
                .map(lotto -> lotto.countMatchingWinningNumbers(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }
}
