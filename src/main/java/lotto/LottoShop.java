package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLottoTickets(LottoAmount lottoAmount) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        int count = lottoAmount.getAmount() / LOTTO_PRICE;
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(lottoGenerator.generateLotto());
        }
        return lottoTickets;
    }


}
