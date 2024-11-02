package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = readValidPurchaseAmount();
        System.out.println("Final purchase amount: " + purchaseAmount);

        List<Integer> winningNumbers = inputWinningNumbers();
        System.out.println("Winning numbers: " + winningNumbers);

        int bonusNumber = inputBonusNumber(winningNumbers);
        System.out.println("Bonus number: " + bonusNumber);

        List<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);
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

    private static List<Integer> generateSingleLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);  // 오름차순 정렬
        return lottoNumbers;
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
}
