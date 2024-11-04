package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoCollection {
    private final List<Lotto> lottoCollection;

    public LottoCollection(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoCollection) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getLottoCount() {
        return lottoCollection.size();
    }

    public Map<Integer, Long> matchWinningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottoCollection.stream()
                .map(lotto -> lotto.getPrize(winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
