package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT);
        }

        final int maxLength = 300;
        if (input.length() >= maxLength) {
            throw new IllegalArgumentException(ErrorMessages.LONG_INPUT);
        }
    }

    public static int requestPurchaseAmount() {
        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                validateInput(input);
                int amount = Integer.parseInt(input);
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException(ErrorMessages.INVALID_AMOUNT_UNIT);
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> requestWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                validateInput(input);
                List<Integer> numbers = parseNumbers(input);

                if (numbers.size() != 6) {
                    throw new IllegalArgumentException(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
                }
                if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
                    throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBER_OUT_OF_RANGE);
                }
                if (numbers.stream().distinct().count() != 6) {
                    throw new IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBER);
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int requestBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                validateInput(input);
                int bonusNumber = Integer.parseInt(input);
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE);
                }
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE);
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}