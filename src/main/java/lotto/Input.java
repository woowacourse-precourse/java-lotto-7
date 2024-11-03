package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    @FunctionalInterface
    private interface InputParser<T> {
        T parse(String input);
    }

    private static <T> T validateInput(String promptMessage, InputParser<T> parser) {
        while (true) {
            System.out.println(promptMessage);
            String input = Console.readLine();
            try {
                return parser.parse(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getCost() {
        return validateInput("구입금액을 입력해 주세요.", Input::parseCost);
    }

    public static List<Integer> getWinNumbers() {
        return validateInput("당첨 번호를 입력해 주세요.", Input::parseWinNumbers);
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        return validateInput("보너스 번호를 입력해 주세요", input -> parseBonusNumber(input, winningNumbers));
    }


    private static int parseCost(String input) {
        try {
            if(Integer.parseInt(input) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구매 비용은 1,000원 단위로 입력할 수 있습니다.");
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 비용은 숫자만 입력할 수 있습니다.");
        }
    }

    private static List<Integer> parseWinNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .toList();
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 숫자만 들어올 수 있습니다.");
        }
    }

    private static int parseBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
        }
    }
}
