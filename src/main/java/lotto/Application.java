package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int ticketCount = calculateTicketCount(purchaseAmount);
        printTicketCount(ticketCount);

        List<Lotto> tickets = generateTickets(ticketCount);
        printTickets(tickets);

        Lotto winningLotto = getWinningNumbers();
        int bonusNumber = getBonusNumber();
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    private static int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    private static List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return tickets;
    }

    private static void printTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println(ticket.printTicketDetail());
        }
        System.out.println();
    }

    private static Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseNumbers();
        return new Lotto(winningNumbers);
    }

    private static List<Integer> parseNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}
