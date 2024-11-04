package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static int validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }
    public static List<Lotto> buyLottoTickets(int amount) {
        int ticketCount = amount / LOTTO_PRICE;
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Lotto.generateLottoNumbers();
            tickets.add(new Lotto(numbers));
        }
        return tickets;
    }
}
