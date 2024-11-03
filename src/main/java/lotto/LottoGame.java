package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class LottoGame {
    private final int Lotto_PRICE = 1000;
    private final LottoMachine lottoMachine = new LottoMachine();
    private List<Lotto> userTickets;
    private Lotto winningTicket;
    private int bonusNumber;

    public void start() {
        int amount = inputAmount();
        int ticketCount = lottoMachine.calculateTicketCount(amount);

        userTickets = generateTickets(ticketCount);
        printTickets(userTickets);

        winningTicket = inputWinningTicket();
        bonusNumber = inputBonusNumber();

        printResults();
    }

    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int amount = ValidationUtil.parseAndValidateNumber(input);
            ValidationUtil.validateAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    private List<Lotto> generateTickets(int count) {
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tickets.add(lottoMachine.generateTicket());
        }
        return tickets;
    }

    private Lotto inputWinningTicket() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            Set<Integer> numbers = ValidationUtil.parseAndValidateWinningNumbers(input);
            return new Lotto(List.copyOf(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningTicket();
        }
    }

    private int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            int number = ValidationUtil.parseAndValidateNumber(input);
            ValidationUtil.validateBonusNumber(number, winningTicket.getNumbers().stream().collect(Collectors.toSet()));
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private void printTickets(List<Lotto> tickets) {
        System.out.println("\n" + tickets.size() + "개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    private void printResults() {
        int[] matchCounts = calculateMatchCounts();
        int totalPrize = calculateTotalPrize(matchCounts);

        printMatchResult(matchCounts);
        printProfitRate(totalPrize);
    }

    private int[] calculateMatchCounts() {
        int[] matchCounts = new int[5];

        for (Lotto ticket : userTickets) {
            int matchCount = ticket.matchCount(winningTicket);
            boolean bonusMatch = ticket.contains(bonusNumber);

            if (matchCount == 6) matchCounts[0]++;
            else if (matchCount == 5 && bonusMatch) matchCounts[1]++;
            else if (matchCount == 5) matchCounts[2]++;
            else if (matchCount == 4) matchCounts[3]++;
            else if (matchCount == 3) matchCounts[4]++;
        }
        return matchCounts;
    }

    private int calculateTotalPrize(int[] matchCounts) {
        return matchCounts[0] * 2_000_000_000
                + matchCounts[1] * 30_000_000
                + matchCounts[2] * 1_500_000
                + matchCounts[3] * 50_000
                + matchCounts[4] * 5_000;
    }

    private void printMatchResult(int[] matchCounts) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + matchCounts[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[0] + "개");
    }

    private void printProfitRate(int totalPrize) {
        int totalSpent = userTickets.size() * Lotto_PRICE;
        double profitRate = (double) totalPrize / totalSpent * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
