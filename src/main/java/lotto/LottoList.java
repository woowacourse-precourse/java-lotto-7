package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int size() {
        return lottoList.size();
    }

    public List<Integer> getMatchCounts(List<Integer> winningNumbers, int bonusNumber) {
        return lottoList.stream()
                .map(lotto -> lotto.countMatchingWinningNumbers(winningNumbers, bonusNumber))
                .collect(Collectors.toList());
    }
}
