package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoList;

public class LottoService {

    public LottoService() {
    }

    public LottoList buyLottos(InputMoney inputMoney) {
        long buyAmount = inputMoney.getBuyAmount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<buyAmount;i++) {
            Lotto newLotto = Lotto.create();
            lottos.add(newLotto);
        }
        return LottoList.create(lottos);
    }
}
