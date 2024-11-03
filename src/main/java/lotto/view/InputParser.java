package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.validation.InputValidator;

public class InputParser {
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
        // 이 클래스 내부의 private 메소드로 validation을 둘까?
        // 객체에서 따로 validation을 하는 것과 동일한 맥락일 수 있을 것 같음
        InputValidator.validateMultiNumberInput(trimNumbers);
        return trimNumbers.stream().map(Integer::parseInt).toList();
    }

    public static int parseNumber(String input) {
        String trimNumber = input.trim();
        InputValidator.isInputNumber(trimNumber);
        return Integer.parseInt(trimNumber);
    }
}
