package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class LottoService {

    public LottoService() {
    }

    public Lottos buyLottos(InputMoney inputMoney) {
        long buyAmount = inputMoney.getBuyAmount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<buyAmount;i++) {
            Lotto newLotto = Lotto.create();
            lottos.add(newLotto);
        }
        return Lottos.create(lottos);
    }
}
