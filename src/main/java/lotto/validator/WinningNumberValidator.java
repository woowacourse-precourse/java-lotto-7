package lotto.validator;

import java.util.List;
import lotto.parser.InputParser;

public class WinningNumberValidator implements InputValidator{

    public void validate(String input){
        validateNull(input);
        validateNumeric(parseNumbers(input));
    }

    private List<String> parseNumbers(String input) {
        return InputParser.parseInputString(input);
    }

    private void validateNull(String input) {
        if (input.isEmpty() | input == null){
            throw new IllegalArgumentException("[ERROR] 당첨 번호을 입력하세요");
        }
    }

    private void validateNumeric(List<String> inputs) {
        for (String input : inputs)
            if (isNotNumeric(input)){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.");
        }
    }

    private boolean isNotNumeric(String input) {
        return !input.matches("\\d+");
    }
}
