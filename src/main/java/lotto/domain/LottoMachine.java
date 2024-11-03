package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {

    private final int LOTTO_PRICE = 1000;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int COUNT = 6;

    public List<Lotto> generateLotto(int price) {
        int quantity = price / LOTTO_PRICE;

        return Stream.generate(
                        () -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT)))
                .limit(quantity)
                .toList();
    }

}
