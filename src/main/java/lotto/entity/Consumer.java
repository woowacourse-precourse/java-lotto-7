package lotto.entity;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Consumer {
    private final int totalLottoCost;
    private final int lottoCount;
    private static final int LOTTO_PRICE = 1000;
    private final List<List<Integer>> lottoTickets; // 생성된 티켓을 저장할 변수

    public Consumer() {
        System.out.println("구입 금액을 입력해 주세요.");
        this.totalLottoCost = Integer.parseInt(Console.readLine());
        validateTotalLottoCost();

        this.lottoCount = totalLottoCost / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);

        this.lottoTickets = generateLottoTickets(); // 티켓을 생성하고 저장
    }

    private void validateTotalLottoCost() {
        if (totalLottoCost <= 0 || totalLottoCost % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");
        }
    }

    private List<List<Integer>> generateLottoTickets() {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> ticket = new ArrayList<>();
            while (ticket.size() < 6) {
                int number = random.nextInt(45) + 1;
                if (!ticket.contains(number)) {
                    ticket.add(number);
                }
            }
            Collections.sort(ticket);
            lottoTickets.add(ticket);
        }

        lottoTickets.forEach(System.out::println);
        return lottoTickets; // 생성된 티켓을 반환
    }

    public int getTotalLottoCost() {
        return totalLottoCost;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<List<Integer>> getLottoTickets() { // 티켓을 반환하는 새로운 메서드
        return lottoTickets;
    }
}
