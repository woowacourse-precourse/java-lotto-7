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
        LottoAmount lottoAmount = new LottoAmount(amount);

        int count = lottoAmount.getAmount() / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
        return lottos;
    }


}
