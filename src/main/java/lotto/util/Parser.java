package lotto.util;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.SystemConfig.DELIMITER;

public class Parser {
    public static Bonus parseBonusNumber(String input) {
        int number = Parser.parseNumber(input);
        return new Bonus(number);
    }

    public static Purchase parsePurchase(String input) {
        int cost = Parser.parseNumber(input);
        return new Purchase(cost);
    }

    public static Lotto parseLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(Parser::parseNumber)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
