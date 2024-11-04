package lotto.domain;

import lotto.constant.NumberConstant;
import lotto.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final NumberGenerator numberGenerator;
    private final PurchaseMoney purchaseMoney;

    public LottoMachine(NumberGenerator numberGenerator, PurchaseMoney purchaseMoney) {
        this.numberGenerator = numberGenerator;
        this.purchaseMoney = purchaseMoney;
    }

    public Lottos createLottos() {
        List<Lotto> result = new ArrayList<>();
        int lottoAmount = purchaseMoney.getMoney() / NumberConstant.LOTTO_PRICE;

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = numberGenerator.pickNumInRange();
            Lotto lotto = new Lotto(numbers);
            result.add(lotto);
        }

        return new Lottos(result, purchaseMoney);
    }
}
