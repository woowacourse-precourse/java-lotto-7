package lotto.parser;

import lotto.config.LottoConfig;

import java.util.HashSet;
import java.util.Set;

public class InputLottoParser implements Parser {

    private final String delimiter;

    public InputLottoParser(ParserConfig config) {
        this.delimiter = config.getDelimiter();
    }

    @Override
    public String[] parse(String input) {
        String[] tokens = input.split(delimiter);
        validate(tokens);
        return tokens;
    }

    private void validate(String[] numbers) {
        validateCount(numbers);
        validateDuplicates(numbers);
        validateNumeric(numbers);
        validateRange(numbers);
    }

    private void validateCount(String[] numbers) {
        if (numbers.length != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정확히 " + LottoConfig.LOTTO_SIZE + "개여야 합니다. 현재 개수: " + numbers.length);
        }
    }

    private void validateDuplicates(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다: " + number);
            }
        }
    }

    private void validateRange(String[] numbers) {
        for (String token : numbers) {
            int number = Integer.parseInt(token);
            if (number < LottoConfig.START_NUMBER || number > LottoConfig.END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoConfig.START_NUMBER + " 이상 " + LottoConfig.END_NUMBER + " 이하의 양의 정수만 입력 가능합니다. 현재 숫자: " + number);
            }
        }
    }

    private void validateNumeric(String[] numbers) {
        for (String number : numbers) {
            if (!isNumeric(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 입력 가능합니다. 현재 입력값: " + number);
            }
        }
    }

    private boolean isNumeric(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
