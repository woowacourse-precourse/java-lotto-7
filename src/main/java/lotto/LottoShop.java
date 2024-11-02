package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;
    private final LottoGenerator lottoGenerator;

    public LottoShop(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLottoTickets(int amount) {
        validateAmount(amount);

        int count = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
        return lottos;
    }

    private void validateAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 이상 가능합니다.");
        }

        int change = amount % 1000;
        if (change != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위로 가능합니다.");
        }
    }
}
