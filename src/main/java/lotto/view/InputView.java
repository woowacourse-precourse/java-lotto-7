package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어 있습니다. 다시 입력해 주세요.");
        }

        final int maxLength = 300;
        if (input.length() >= maxLength) {
            throw new IllegalArgumentException("[ERROR] 입력값이 너무 깁니다.");
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
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
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
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
                }
                if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
                    throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (numbers.stream().distinct().count() != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않은 숫자여야 합니다.");
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
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
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 입력입니다. 숫자를 입력해 주세요.");
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