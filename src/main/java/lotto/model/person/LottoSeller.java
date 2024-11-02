package lotto.model.person;

import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.Lottos;
import lotto.model.lottogenerator.LottoGenerator;
import lotto.model.lottogenerator.RandomLottoNumberGenerator;

public class LottoSeller {
    protected static final int LOTTO_UNIT_AMOUNT = 1000;
    private final LottoMachine lottoMachine;

    public LottoSeller() {
        LottoGenerator generateStrategy = new RandomLottoNumberGenerator();
        this.lottoMachine = new LottoMachine(generateStrategy);
    }

    public Lottos sellTo(final int amount) {
        validate(amount);
        int count = calculateLottoCount(amount);
        return lottoMachine.execute(count);
    }

    private int calculateLottoCount(final int amount) {
        return amount / LOTTO_UNIT_AMOUNT;
    }

    private void validate(final int amount) {
        validateAmountRange(amount);
        validateAmount(amount);
    }

    private void validateAmount(final int amount) {
        if (amount % LOTTO_UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로 투입되어야 합니다.");
        }
    }

    private void validateAmountRange(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수인 숫자를 입력해주세요.");
        }
    }
}
