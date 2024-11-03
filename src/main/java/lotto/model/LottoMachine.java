package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_PRICE = 1_000;

    private int calculateNumberOfLotteries(int payAmount) {
        return payAmount/LOTTO_PRICE;
    }
    public List<Lotto> publishLotteries(int payAmount) {
        int count = calculateNumberOfLotteries(payAmount);
        List<Lotto> all_lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> marked_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            marked_numbers.sort(Comparator.naturalOrder());
            all_lottos.add(new Lotto(marked_numbers));
        }
        return all_lottos;
    }
}
