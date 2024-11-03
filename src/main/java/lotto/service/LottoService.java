package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoConstants;
import lotto.domain.LottoMachine;

public class LottoService {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public void purchaseLottos(int amount) {
        int count = amount / LottoConstants.LOTTO_NUMBERS_COUNT;
        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoMachine.generateRandomLotto();
            purchasedLottos.add(lotto);
        }
    }
}
