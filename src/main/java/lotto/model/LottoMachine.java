package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.helper.util.RandomUtil;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT_NUMBER = 6;

    public LottoTicket purchaseTicket(int price) {
        int count = price / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return new LottoTicket(lottos, price);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = RandomUtil.generateRandomNumbers(START_NUMBER, END_NUMBER, COUNT_NUMBER);
        return new Lotto(numbers);
    }
}
