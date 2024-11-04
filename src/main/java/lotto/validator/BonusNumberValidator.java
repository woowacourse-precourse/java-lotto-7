package lotto.validator;

import java.util.List;
import lotto.parser.InputParser;

public class BonusNumberValidator {

    public void validate(String input){
        validateNull(input);
        validateNumeric(input);
    }

    private void validateNull(String input) {
        if (input.isEmpty() & input == null){
            throw new IllegalArgumentException("[ERROR] 보너스 번호을 입력하세요");
        }
    }

    private void validateNumeric(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자입니다..");
        }
    }

    private boolean isNotNumeric(String input) {
        return !input.matches("\\d+");
    }
}
