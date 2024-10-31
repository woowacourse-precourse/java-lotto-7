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
        // 1. validation의 결과로 List<Integer>을 내려주는 것과
        // 2. validation은 진짜 validation만 수행하는 것 중 무엇이 나은지 고민됨
        // 1번으로 가면 Integer.parseInt()를 통해 별도 로직 없이 숫자 체크를 할 수 있음
        // 다만, validation의 책임이 늘어나는 것처럼 보이기도 함
        NumberValidator.validateLottoNumberString(trimNumbers);
        return trimNumbers.stream().map(Integer::parseInt).toList();
    }

    public static int parseBonusNumber(String input) {
        String trimNumber = input.trim();
        NumberValidator.validateBonusNumberString(trimNumber);
        return Integer.parseInt(trimNumber);
    }
}
