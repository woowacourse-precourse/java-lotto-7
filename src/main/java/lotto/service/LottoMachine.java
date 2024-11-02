package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.model.RandomNumberPicker;

public class LottoMachine {
    public Lottos issueLottos(LottoAmount lottoAmount) {
        List<Lotto> lottos = IntStream.range(0, lottoAmount.getLottoAmount())
                .mapToObj(i -> new Lotto(RandomNumberPicker.pickAscendingNumbers()))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

}
