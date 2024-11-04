package lotto.domain;

import lotto.Lotto;
import lotto.common.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoParser {
    private final String input;

    public LottoParser(String input) {
        this.input = input;
    }

    public Lotto parse() {
        try {
            List<String> splitNumbers = this.splitByComma();
            List<Integer> numbers = parseInteger(splitNumbers);
            validateNumbers(numbers);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.unknownError);
        }
    }

    private List<String> splitByComma() {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }

    private List<Integer> parseInteger(List<String> splitNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitNumbers) {
            Integer parsedNumber = Integer.parseInt(number);
            numbers.add(parsedNumber);
        }
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validate(number);
        }
    }

    private void validate(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.lottoNumberOutOfRange);
        }
    }
}
