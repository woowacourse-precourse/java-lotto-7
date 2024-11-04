package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;
    private LottoGenerator lottoGenerator;

    public LottoStore() {
        this.lottoGenerator = new LottoGenerator();
    }

    public int calculateLottoCount(int money) {
        validateMoney(money);
        return money / LOTTO_PRICE;
    }

    public List<Lotto> sell(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다.");
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.");
        }
    }

}
