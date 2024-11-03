package lotto.view;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static final String INPUT_DELIMITER = ",";

    public int parseLottoPurchasePrice(String numbers) {
        int number = parseStringToInteger(numbers);
        if (isNotDivisibleByThousand(number)) {
            throw new IllegalArgumentException("ERROR 잘못된 입력입니다. 로또는 1000원당 한장입니다.");
        }
        return number;
    }

    public int parseStringToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 숫자만 입력할 수 있습니다.");
        }
    }

    public List<Integer> parseWinningLottoNumbers(String numbers) {
        validateNumbersInput(numbers);
        return splitAndParseToIntegerList(numbers);
    }

    private void validateNumbersInput(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 번호를 입력해주세요.");
        }
    }

    private List<Integer> splitAndParseToIntegerList(String numbers) {
        try {
            String removedSpacesNumbers = removeSpaces(numbers);
            return Arrays.stream(removedSpacesNumbers.split(INPUT_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 숫자만 입력할 수 있습니다.");
        }
    }

    private String removeSpaces(String numbers) {
        return numbers.replace(" ", "");
    }

    private boolean isNotDivisibleByThousand(int number) {
        return number % 1000 != 0;
    }
}
