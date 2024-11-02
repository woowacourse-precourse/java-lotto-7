package lotto.model;

import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.Lottos;
import lotto.model.lottogenerator.LottoGenerator;
import lotto.model.lottogenerator.RandomLottoNumberGenerator;

public class LottoSeller {
    private static final int UNIT_AMOUNT = 1000;
    private final LottoMachine lottoMachine;

    public LottoSeller() {
        LottoGenerator generateStrategy = new RandomLottoNumberGenerator();
        this.lottoMachine = new LottoMachine(generateStrategy);
    }

    public Lottos sellTo(final int amount) {
        validateAmount(amount);
        int count = calculateLottoCount(amount);
        return lottoMachine.execute(count);
    }

    private int calculateLottoCount(final int amount) {
        return amount / UNIT_AMOUNT;
    }

    private void validateAmount(final int amount) {
        if (amount < UNIT_AMOUNT || amount % UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로 투입되어야 합니다.");
        }
    }
}
