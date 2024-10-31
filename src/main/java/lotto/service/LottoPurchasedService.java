package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessage;
import lotto.util.NumberGenerate;
import lotto.model.Lotto;

public class LottoPurchasedService {

    private final NumberGenerate lottoGenerator;

    public static final int LOTTO_PRICE = 1000;

    public LottoPurchasedService(NumberGenerate lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> purchaseLotto(int money) {
        validateMoneyModLottoPrice(money);
        int lottoCnt = money / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < lottoCnt; cnt++) {
            List<Integer> numbers = lottoGenerator.randomGenerateInRange(1, 45);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private void validateMoneyModLottoPrice(int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_MOD_PRICE.getMsg());
        }
    }
}
