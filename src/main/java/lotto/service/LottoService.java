package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.SoldLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final SoldLotto soldLotto;

    public LottoService(SoldLotto soldLotto){
        this.soldLotto = soldLotto;
    }

    public String buyLotto(int lottoCount) {
        for (int index = 0; index < lottoCount; index++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER_COUNT).stream().sorted().toList());
            soldLotto.addLottoSold(lotto);
        }

        return soldLotto.getLottoDetails().toString();
    }
}
