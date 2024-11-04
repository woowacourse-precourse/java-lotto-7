package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public void startGame() {
        int amount = promptPurchaseAmount();
        int ticketCount = calculateTicketCount(amount);
        List<Lotto> purchasedLottos = generateTickets(ticketCount);

        printPurchasedLottos(ticketCount, purchasedLottos);

        List<Integer> winningNumbers = promptWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);

        int bonusNumber = promptBonusNumber(winningNumbers);

        Map<LottoRank, Integer> results = calculateResults(purchasedLottos, winningLotto, bonusNumber);
        printResults(amount, results);
    }

    private int promptPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = parseAmount(Console.readLine());
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 하며, 1,000원 단위여야 합니다.");
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

    private int calculateTicketCount(int amount) {
        return amount / LOTTO_TICKET_PRICE;
    }

    private List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(LottoGenerator.generate());
        }
        return tickets;
    }

    private void printPurchasedLottos(int ticketCount, List<Lotto> purchasedLottos) {
        System.out.println("\n" + ticketCount + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private List<Integer> promptWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                List<Integer> numbers = parseNumbers(Console.readLine());
                LottoValidator.validate(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int promptBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                int bonusNumber = parseBonusNumber(Console.readLine());
                LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        }
    }

    private Map<LottoRank, Integer> calculateResults(List<Lotto> tickets, Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (Lotto ticket : tickets) {
            LottoRank rank = LottoResultCalculator.determineRank(ticket, winningLotto, bonusNumber);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }

    private void printResults(int amount, Map<LottoRank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankResults(results);

        long totalPrize = calculateTotalPrize(results);
        double returnRate = LottoResultCalculator.calculateReturnRate(amount, totalPrize);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

    private void printRankResults(Map<LottoRank, Integer> results) {
        System.out.printf("3개 일치 (%s원) - %d개%n", formatPrize(LottoRank.FIFTH.getPrizeMoney()), results.getOrDefault(LottoRank.FIFTH, 0));
        System.out.printf("4개 일치 (%s원) - %d개%n", formatPrize(LottoRank.FOURTH.getPrizeMoney()), results.getOrDefault(LottoRank.FOURTH, 0));
        System.out.printf("5개 일치 (%s원) - %d개%n", formatPrize(LottoRank.THIRD.getPrizeMoney()), results.getOrDefault(LottoRank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n", formatPrize(LottoRank.SECOND.getPrizeMoney()), results.getOrDefault(LottoRank.SECOND, 0));
        System.out.printf("6개 일치 (%s원) - %d개%n", formatPrize(LottoRank.FIRST.getPrizeMoney()), results.getOrDefault(LottoRank.FIRST, 0));
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> results) {
        return results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    private String formatPrize(long prizeMoney) {
        return String.format("%,d", prizeMoney);
    }

    private List<Integer> parseNumbers(String input) {
        String[] split = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : split) {
            try {
                numbers.add(Integer.parseInt(num.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
            }
        }
        return numbers;
    }
}
