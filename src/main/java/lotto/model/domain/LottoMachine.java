package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstantValue;

public class LottoMachine {
    private final int money;
    private final int lottoCount;

    public LottoMachine(int money) {
        isPaymentOverMaxLimitValidator(money);
        isPaymentDivisionByLottoPriceValidator(money);
        this.money = money;
        this.lottoCount = money / LottoConstantValue.LOTTO_PRICE.getValue();
    }

    public Lotto singleLottoGenerator() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoConstantValue.LOTTO_MIN_NUM.getValue(),
                LottoConstantValue.LOTTO_MAX_NUM.getValue(),
                LottoConstantValue.LOTTO_NUMBER_SIZE.getValue()
        ));
    }

    public List<Lotto> multipleLottoGenerator() {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.add(singleLottoGenerator());
        }
        return lottoBundle;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void isPaymentOverMaxLimitValidator(int money) {
        if (money > LottoConstantValue.LOTTO_MAX_PAYMENT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.IS_PAYMENT_OVER_MAX_LIMIT_VALIDATOR.getMessage());
        }
    }

    private void isPaymentDivisionByLottoPriceValidator(int money) {
        if (money <= 0 || money % LottoConstantValue.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_PAYMENT_DIVISION_BY_LOTTO_PRICE_VALIDATOR.getMessage());
        }
    }


}
