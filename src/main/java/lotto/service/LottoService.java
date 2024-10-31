package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.contants.value.LottoValue;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private List<Lotto> lottos;

    public LottoService() {
        this.lottos = new ArrayList<>();
    }

    public void buyLotto(int payment) {
        int countLotto = countLotto(payment);
        getLotto(countLotto);
    }

    public int countLotto(int payAmount) {
        return payAmount / LottoValue.AMOUNT_UNIT;
    }

    public void getLotto(int countLotto) {
        for (int i = 0; i < countLotto; i++) {
            lottos.add(createLotto());
        }
    }

    public Lotto createLotto() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        randoms.sort(null);
        return new Lotto(randoms);
    }
}
