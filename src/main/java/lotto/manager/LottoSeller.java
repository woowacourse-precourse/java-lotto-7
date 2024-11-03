package lotto.manager;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.util.LottoNumberSupplier;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private static final int LOTTO_PRISE = 1000;
    private final LottoNumberSupplier lottoNumberSupplier;

    public LottoSeller(LottoNumberSupplier lottoNumberSupplier) {
        this.lottoNumberSupplier = lottoNumberSupplier;
    }

    public Player sell(int money) {
        List<Lotto> lottos = new ArrayList<>();

        int count = calculateLottoCount(money);

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = lottoNumberSupplier.getLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }

        return new Player(lottos, money);
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRISE;
    }
}
