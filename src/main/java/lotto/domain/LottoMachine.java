package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_AMOUNT = "[ERROR] 로또 구매금액은 1000원 이상이어야 합니다.";

    public List<Lotto> purchase(int money) {
        validateMoney(money);
        int count = money / LOTTO_PRICE;
        return createLottos(count);
    }

    private void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0 || money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_AMOUNT);
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
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }
}
