package lotto;

import java.util.ArrayList;
import java.util.Arrays;
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

        public static List<Integer> getWinningNumbers(String input) {
            List<String> parts = Arrays.asList(input.split(","));
            List<Integer> winningNumbers = new ArrayList<>();
            for (String part : parts) {
                winningNumbers.add(Integer.parseInt(part.trim()));
            }
            return winningNumbers;
        }

        public static int getBonusNumber(String input) {
            return Integer.parseInt(input.trim());
        }

}
