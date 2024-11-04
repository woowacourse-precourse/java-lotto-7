package lotto.domain;

import lotto.Lotto;
import lotto.common.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoParser {

    public static Lotto parse(String input) {
        try {
            List<String> splitNumbers = splitByComma(input);
            List<Integer> numbers = parseInteger(splitNumbers);
            validateNumbers(numbers);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.unknownError);
        }
    }

    private static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }

    private static List<Integer> parseInteger(List<String> splitNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitNumbers) {
            Integer parsedNumber = Integer.parseInt(number);
            numbers.add(parsedNumber);
        }
        return numbers;
    }

    private static void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validate(number);
        }
    }

    private static void validate(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.lottoNumberOutOfRange);
        }
    }
}
