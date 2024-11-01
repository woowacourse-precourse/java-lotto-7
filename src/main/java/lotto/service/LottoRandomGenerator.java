package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.Constants;

public class LottoRandomGenerator implements LottoGenerator {

    private long money;

    public void setMoney(long money) {
        this.money = money;
    }

    public List<Lotto> getLottos() {
        List<Lotto> lottos = new ArrayList<>();

        long ticket_count = money / Constants.LOTTO_PRICE.getLong();

        for (int i = 0; i < ticket_count; i++) {
            lottos.add(getLotto());
        }

        return lottos;
    }

    public Lotto getLotto() {
        List<Integer> numbers = generateRandomNumbers();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    protected List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER.getNumber(),
                Constants.MAX_LOTTO_NUMBER.getNumber(),
                Constants.LOTTO_NUMBER_COUNT.getNumber());
    }
}
