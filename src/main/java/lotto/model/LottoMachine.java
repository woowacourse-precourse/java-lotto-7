package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.model.LottoConstants.LOTTO_PRICE;

public class LottoMachine {

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
