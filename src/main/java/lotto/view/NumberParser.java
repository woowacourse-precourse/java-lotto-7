package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.validation.NumberValidator;

public class NumberParser {
    private static final String COMMA = ",";

    public static List<Integer> parseLottoNumbers(String input) {
        String[] splitNumbers = input.split(COMMA);
        List<String> trimNumbers = new ArrayList<>();
        for(String number: splitNumbers) {
            trimNumbers.add(number.trim());
        }
        NumberValidator.validateLottoNumberString(trimNumbers);
        return trimNumbers.stream().map(Integer::parseInt).toList();
    }

    public static int parseBonusNumber(String input) {
        String trimNumber = input.trim();
        //TODO: 숫자 아닌 입력 validation 추가 필요
        return Integer.parseInt(trimNumber);
    }
}
