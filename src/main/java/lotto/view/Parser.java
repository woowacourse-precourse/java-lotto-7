package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.utils.InputUtils;

public class Parser {

    public static final String INPUT_DELIMITER = ",";

    public int parseLottoPurchasePrice(String value) {
        int number = parseStringToInteger(value);
        InputValidator.validateDivisibleByThousand(number);
        return number;
    }

    public int parseStringToInteger(String value) {
        InputValidator.validateEmptyInput(value);
        return InputUtils.convertToInt(value);
    }

    public List<Integer> parseWinningLottoNumbers(String value) {
        InputValidator.validateEmptyInput(value);
        return splitAndParseToIntegerList(value);
    }

    private List<Integer> splitAndParseToIntegerList(String numbers) {
        String removedSpacesNumbers = removeSpaces(numbers);
        return Arrays.stream(removedSpacesNumbers.split(INPUT_DELIMITER))
                .map(InputUtils::convertToInt)
                .toList();
    }

    private String removeSpaces(String numbers) {
        return numbers.replace(" ", "");
    }
}
