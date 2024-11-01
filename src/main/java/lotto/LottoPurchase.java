package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    public void start() {
        int purchaseAmount = getPurchaseAmount();
        int ticketCount = purchaseAmount / 1000;

        System.out.println(ticketCount + "개를 구매했습니다.");
        List<List<Integer>> lottoTickets = generateLottoTickets(ticketCount);
        printLottoTickets(lottoTickets);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine().trim());

                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<List<Integer>> generateLottoTickets(int ticketCount) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            ticket.sort(Integer::compareTo);
            tickets.add(ticket);
        }
        return tickets;
    }

    private void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

    public static void main(String[] args) {
        new LottoPurchase().start();
    }
}
