package lotto.service;

import lotto.model.Lotto;
import lotto.utils.LottoRules;

public class LottoService {


    public Lotto generateLotto() {
        Lotto newLotto = new Lotto(LottoRules.pickRandomNumbers());
        return newLotto;
    }
}
