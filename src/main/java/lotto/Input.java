package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.Constant.*;

public class Input {
    @FunctionalInterface
    private interface InputParser<T> {
        T parse(String input);
    }

    private static <T> T input(String promptMessage, InputParser<T> parser) {
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
        return input("구입금액을 입력해 주세요.", Input::parseCost);
    }

    public static List<Integer> getWinNumbers() {
        return input("당첨 번호를 입력해 주세요.", Input::parseWinNumbers);
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        return input("보너스 번호를 입력해 주세요", input -> parseBonusNumber(input, winningNumbers));
    }

    private static int parseCost(String input) {
        int cost = parseInteger(input);
        if (cost % LOTTO_CHARGE != ZERO) {
            throw new IllegalArgumentException("[ERROR] 구매 비용은 1,000원 단위로 입력할 수 있습니다.");
        }
        if (cost < ZERO) {
            throw new IllegalArgumentException("[ERROR] 구매 비용은 양수이여야 합니다.");
        }

        return cost;
    }

    private static List<Integer> parseWinNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(SPLITER))
                .map(Input::parseInteger)
                .toList();

        if (numbers.size() != LOTTO_NUMBERS_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }

        return numbers;
    }

    private static int parseBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = parseInteger(input);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
