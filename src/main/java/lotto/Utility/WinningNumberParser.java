package lotto.Utility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberParser {

    public static List<Integer> parseWinningNumbers(String inputtedNumbers) {
        List<Integer> parsedNumbers = Stream.of(inputtedNumbers.split(","))
                .map(String::trim)
                .map(rawNumber -> {
                    return stringToInt(rawNumber);
                })
                .collect(Collectors.toList());

        validateLength(parsedNumbers);
        return parsedNumbers;
    }

    private static int stringToInt(String rawNumber) {
        try {
            int number = Integer.parseInt(rawNumber);
            validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자를 입력하셨습니다.");
        }
    }

    private static void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 수는 입력하실 수 없습니다.");
        }
    }

    private static void validateLength(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }
}
