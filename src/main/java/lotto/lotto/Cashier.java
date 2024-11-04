package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.value.Lotto;
import lotto.lotto.value.Money;

import java.util.List;
import java.util.stream.IntStream;

public class Cashier {

    private static final int LOTTO_PRICE = 1000;

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    private Money income;

    public List<Lotto> sellLotto(Money money) {
        this.income = money;
        int ticketCount = money.buy(LOTTO_PRICE);

        return IntStream.range(0, ticketCount)
                .mapToObj(i -> issueLotto())
                .toList();
    }

    private Lotto issueLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
        return new Lotto(lottoNumbers);
    }

    public Money getIncome() {
        return income;
    }
}
