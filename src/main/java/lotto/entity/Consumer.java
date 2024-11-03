package lotto.entity;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Consumer {
    private final int totalLottoCost;
    private final int lottoCount;
    private static final int LOTTO_PRICE = 1000;
    private final List<List<Integer>> lottoTickets;

    public Consumer() {
        totalLottoCost = inputTotalLottoCost();
        lottoCount = calculateLottoCount(totalLottoCost);
        printLottoCount();  // 구매한 로또 수 출력
        lottoTickets = generateLottoTickets();
        printLottoTickets(); // 로또 번호 출력
    }

    private int inputTotalLottoCost() {
        int cost = 0;
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                cost = Integer.parseInt(Console.readLine());
                validateTotalLottoCost(cost);
                break; // 유효한 입력일 경우 루프 탈출
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            }
        }
        return cost;
    }

    private int calculateLottoCount(int totalCost) {
        return totalCost / LOTTO_PRICE;
    }

    private void validateTotalLottoCost(int cost) {
        if (cost <= 0 || cost % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");
        }
    }

    private List<List<Integer>> generateLottoTickets() {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> ticket = generateSingleTicket();
            tickets.add(ticket);
        }
        return tickets;
    }

    private List<Integer> generateSingleTicket() {
        List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortTicket(ticket);
    }

    private List<Integer> sortTicket(List<Integer> ticket) {
        List<Integer> mutableTicket = new ArrayList<>(ticket);
        Collections.sort(mutableTicket);
        return mutableTicket;
    }

    private void printLottoCount() {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    private void printLottoTickets() {
        System.out.println("구매한 로또 번호는 다음과 같습니다:");
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

    public int getTotalLottoCost() {
        return totalLottoCost;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }
}
