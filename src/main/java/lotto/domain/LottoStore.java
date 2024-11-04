package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;
    public static List<Lotto> purchaseLotto(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price / LOTTO_PRICE; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
