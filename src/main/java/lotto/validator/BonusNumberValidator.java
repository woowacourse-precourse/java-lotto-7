package lotto.validator;

import java.util.List;
import lotto.parser.InputParser;

public class BonusNumberValidator implements InputValidator{

    public void validate(String input){
        validateNull(input);
        validateNumeric(input);
    }

    private void validateNull(String input) {
        if (input.isEmpty() | input == null){
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력하세요");
        }
    }

    private void validateNumeric(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에는 숫자가 입력됩니다.");
        }
    }

    private boolean isNotNumeric(String input) {
        return !input.matches("\\d+");
    }
}
