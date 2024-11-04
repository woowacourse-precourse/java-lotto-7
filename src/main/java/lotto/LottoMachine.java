package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> tickets = new ArrayList<>();

    public void buyTickets(int amount) {
        validateAmount(amount);
        int ticketCount = amount / LOTTO_PRICE;
        System.out.println("\n" +ticketCount + "개를 구매했습니다.");
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
            System.out.println(lotto.getNumbers());
        }
    }

    private void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}