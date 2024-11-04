package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;

public class LottoMachine {
    private int money;
    private int lottoCount;

    public LottoMachine(int money) {
        isPaymentOverMaxLimitValidator(money);
        isPaymentDivisionByThousandValidator(money);
        this.money = money;
        this.lottoCount = money/1000;
    }
    public Lotto singleLottoGenerator() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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

    private void isPaymentOverMaxLimitValidator(int money){
        if (money > 100_000) {
            throw new IllegalArgumentException(ErrorMessage.IS_PAYMENT_OVER_MAX_LIMIT_VALIDATOR.getMessage());
        }
    }

    private void isPaymentDivisionByThousandValidator(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_PAYMENT_DIVISION_BY_THOUSAND_VALIDATOR.getMessage());
        }
    }



}
