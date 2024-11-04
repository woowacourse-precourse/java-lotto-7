package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;

public class LottoService {

    private Lotto lotto;

    public List<Lotto> buyLottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(0, lottoAmount)
            .forEach(i -> {
                Lotto newLotto = lotto.buyOneLotto();
                lottos.add(newLotto);
            });

        return lottos;
    }
}