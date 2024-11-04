package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.*;

public class LottoService {
    private static final int TICKET_PRICE = 1000;

    public static List<Lotto> generateTickets(int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        int ticketCount = purchaseAmount / TICKET_PRICE;
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateSingleTicket());
        }
        return tickets;
    }

    private static Lotto generateSingleTicket() {
        List<Integer> numbers;
        do {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        } while (numbers.size() != 6); // 6개가 아닌 경우 다시 생성
        return new Lotto(numbers);
    }

    public static Map<LottoResult, Integer> calculateResults(List<Lotto> tickets, Lotto winningLotto, int bonusNumber) {
        Map<LottoResult, Integer> results = new EnumMap<>(LottoResult.class);
        for (Lotto ticket : tickets) {
            int matchCount = (int) ticket.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            LottoResult result = LottoResult.getResult(matchCount, bonusMatch);
            results.put(result, results.getOrDefault(result, 0) + 1);
        }
        return results;
    }
}
