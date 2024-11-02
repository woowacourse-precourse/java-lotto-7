package lotto.service;

import java.util.List;
import lotto.domain.Answer;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.domain.LottoSeller;

public class LottoService {
    private final LottoSeller lottoSeller = new LottoSeller();
    private List<Lotto> lottos;

    public List<Lotto> buy(int price) {
        return lottos = lottoSeller.sell(price);
    }

    public WinningResult getResult(List<Integer> numbers, int bonus) {
        return new Answer(numbers, bonus).getResult(lottos);
    }
}
