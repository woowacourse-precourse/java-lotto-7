package lotto.model.person;

import lotto.common.ErrorMessage;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.Lottos;
import lotto.model.lottogenerator.LottoGenerateStrategy;
import lotto.model.lottogenerator.RandomLottoNumberGenerator;

public class LottoSeller {
    protected static final int LOTTO_UNIT_AMOUNT = 1000;
    private final LottoMachine lottoMachine;

    public LottoSeller() {
        LottoGenerateStrategy generateStrategy = new RandomLottoNumberGenerator();
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_FORMAT.getMessage());
        }
    }

    private void validateAmountRange(final int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_INPUT_ERROR.getMessage());
        }
    }
}
