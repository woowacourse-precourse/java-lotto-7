package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = readValidPurchaseAmount();
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        List<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);

        Map<Rank, Integer> result = calculateResults(lottoTickets, winningNumbers, bonusNumber);
        printResults(result);

        int totalPrize = calculateTotalPrize(result);
        printProfitRate(totalPrize, purchaseAmount);
    }

    private static int readValidPurchaseAmount() {
        while (true) {
            System.out.println("Enter the purchase amount:");
            String input = Console.readLine();

            try {
                int amount = Integer.parseInt(input);
                validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("Enter the winning numbers (comma-separated):");
            String input = Console.readLine();
            List<Integer> numbers = parseWinningNumbers(input);

            try {
                validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validateAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] The purchase amount should be a positive multiple of 1,000.");
        }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("There must be exactly 6 winning numbers.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("Winning numbers must be unique.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("Winning numbers must be between 1 and 45.");
            }
        }
    }

    private static int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("Enter the bonus number:");
            String input = Console.readLine();

            try {
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("The bonus number must be between 1 and 45.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("The bonus number must not be one of the winning numbers.");
        }
    }

    private static List<Lotto> generateLottoTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(Lotto.generate());
        }

        return lottoTickets;
    }

    private static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + " tickets purchased.");
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static Map<Rank, Integer> calculateResults(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> resultMap = new HashMap<>();

        for (Lotto ticket : lottoTickets) {
            int matchCount = ticket.getMatchCount(winningNumbers);
            boolean matchBonus = ticket.containsBonus(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, matchBonus);

            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
        return resultMap;
    }

    static int calculateTotalPrize(Map<Rank, Integer> results) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }

    private static void printResults(Map<Rank, Integer> results) {
        System.out.println("Winning Results:");
        System.out.println("----------------");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.printf("%d개 일치%s (%d원) - %d개%n",
                        rank.ordinal() + 3,
                        (rank == Rank.SECOND ? ", 보너스 볼 일치" : ""),
                        rank.getPrize(),
                        results.getOrDefault(rank, 0));
            }
        }
    }

    private static void printProfitRate(int totalPrize, int purchaseAmount) {
        double profitRate = calculateProfitRate(totalPrize, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    static double calculateProfitRate(int totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }
}
