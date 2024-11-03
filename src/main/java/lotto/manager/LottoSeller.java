package lotto.manager;

import lotto.util.LottoNumberSupplier;

public class LottoSeller {
    private static final int LOTTO_PRISE = 1000;
    private final LottoNumberSupplier lottoNumberSupplier;

    public LottoSeller(LottoNumberSupplier lottoNumberSupplier) {
        this.lottoNumberSupplier = lottoNumberSupplier;
    }

    private int calculateLottoCount(int money) {
        return money / LOTTO_PRISE;
    }
}
