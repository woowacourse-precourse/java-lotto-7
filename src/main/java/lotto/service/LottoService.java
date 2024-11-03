package lotto.service;

import static lotto.config.LottoRule.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.generator.SortedLottoNumberGenerator;

public class LottoService {

    private final SortedLottoNumberGenerator sortedLottoNumberGenerator;

    public LottoService(SortedLottoNumberGenerator sortedLottoNumberGenerator) {
        this.sortedLottoNumberGenerator = sortedLottoNumberGenerator;
    }

    public List<Lotto> purchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = money / LOTTO_PRICE.getValue();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(sortedLottoNumberGenerator.generate()));
        }
        return lottos;
    }

    public LottoResult match(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber) {
        List<Rank> ranks = lottos.stream()
                .map(lotto -> Rank.match(lotto, winNumber, bonusNumber))
                .toList();
        return new LottoResult(ranks);
    }
}
