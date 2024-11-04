package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    // 로또 티켓 발행
    public List<Lotto> createTickets(int amount) {
        List<Lotto> tickets = new ArrayList<>();
        int ticketCount = amount / 1000;

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(createLotto());
        }
        return tickets;
    }

    // 개별 로또 생성 및 번호 오름차순 정렬
    private Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);  // 오름차순 정렬
        return new Lotto(numbers);
    }

    // 발행된 로또 번호 출력
    public void printTickets(List<Lotto> tickets) {
        System.out.printf("%d개를 구매했습니다.%n", tickets.size());
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public Map<PrizeRank, Integer> calculateResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<PrizeRank, Integer> resultMap = new HashMap<>();

        for (Lotto ticket : tickets) {
            int matchCount = (int) ticket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            PrizeRank rank = PrizeRank.getRank(matchCount, bonusMatch);

            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
        return resultMap;
    }
}
