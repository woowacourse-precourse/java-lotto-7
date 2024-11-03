package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.ErrorCode;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchase(int money) {
        validateMoney(money);
        return createLottos(money / LOTTO_PRICE);
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE || money % LOTTO_PRICE != 0) {
            throw ErrorCode.INVALID_PURCHASE_AMOUNT.throwError();
        }
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(createLottoNumber());
        }
        return lottos;
    }

    private Lotto createLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}