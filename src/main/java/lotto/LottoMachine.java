package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;

    public LottoTicket generateTicket() {
        Set<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new LottoTicket(numbers);
    }

    public int calculateTicketCount(int amount) {
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수로 입력해야 합니다.");
        }
    }
}
