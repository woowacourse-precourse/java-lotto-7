package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoVendor {

    private static final int LOTTO_PRICE = 1000;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_COUNT = 6;

    public List<Lotto> issue(int amount) {
        validate(amount);
        int count = amount/LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, NUMBER_COUNT);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private void validate(int amount) {
        if(amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 천원단위여야 합니다.");
        }

        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("요금이 부족합니다");
        }
    }
}
