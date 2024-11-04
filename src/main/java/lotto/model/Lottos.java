package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<List<Integer>> lottoNumbers) {
        return new Lottos(lottoNumbers.stream().map(Lotto::new).collect(Collectors.toList()));
    }

    public Iterator<Lotto> getLottos() {
        return lottos.iterator();
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<LottoResult> getTotalMatchedLottoResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        Iterator<Integer> numbers = winningNumbers.getNumbers();

        for (Lotto lotto : lottos) {
            LottoResult result = lotto.getMatchedLottoResult(numbers, bonusNumber);
            results.add(result);
            numbers = winningNumbers.getNumbers();
        }

        return results;
    }
}
