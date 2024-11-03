package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.helper.util.RandomUtil;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public LottoTicket purchaseTicket(int price) {
        int count = price / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<count; i++) {
            lottos.add(generateLotto());
        }
        return new LottoTicket(lottos, price);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = RandomUtil.generateRandomNumbers();
        return new Lotto(numbers);
    }
}
