package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.config.ErrorMessage;
import lotto.config.SystemConfig;
import lotto.exception.ViewInputException;

public class ValidationService {

    public int isNumber(String input) {
        final String IS_NUMBER = SystemConfig.NUMBER_PATTERN;
        if (!input.matches(IS_NUMBER)) {
            throw new ViewInputException(ErrorMessage.NOT_DIGIT);
        }
        return Integer.parseInt(input);
    }

    public List<String> isListFormat(String input) {
        final String IS_NUMBER_LIST = SystemConfig.LIST_PATTERN;
        if (!input.matches(IS_NUMBER_LIST)) {
            throw new ViewInputException(ErrorMessage.NUMBER_INSUFFICIENT);
        }
        return splitInput(input);
    }

    private List<String> splitInput(String input) {
        final String DELIMITER = SystemConfig.DELIMITER;
        List<String> brokenItems = List.of(input.split(DELIMITER));
        return new ArrayList<>(brokenItems);
    }
}
