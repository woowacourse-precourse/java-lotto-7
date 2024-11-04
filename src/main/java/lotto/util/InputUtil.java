package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    static final String DELIMITER = ",";

    public String readInput() {
        String input = Console.readLine();
        Validator.validateNullInput(input);
        Validator.validateWhitespaceInput(input);
        return input;
    }

    public List<Integer> parseInputToLottoList(String input) {
        Validator.validateRightDelimiter(input);
        String[] numbers = input.split(DELIMITER);
        List<Integer> lottoList = new ArrayList<>();
        for (String number : numbers) {
            Validator.validateNullInput(number);
            Validator.validateWhitespaceInput(number);
            int num = Validator.validateLottoNumber(number);
            lottoList.add(num);
        }
        return lottoList;
    }
}
