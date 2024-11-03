package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;

    public int calculateTicketCount(int amount) {
        ValidationUtil.validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    public Lotto generateTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto((numbers.stream().collect(Collectors.toList())));
    }
}
