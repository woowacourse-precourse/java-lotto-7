package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = readValidPurchaseAmount();
        System.out.println("Final purchase amount: " + purchaseAmount);

        List<Integer> winningNumbers = inputWinningNumbers();
        System.out.println("Winning numbers: " + winningNumbers);
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

            try {
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

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
}
