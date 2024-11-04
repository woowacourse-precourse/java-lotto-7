package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoErrorMessage;

public class WinningNumberParser {

    private static final String SPLIT_CRITERIA = ",";

    public List<Integer> split(String userInput) {
        String[] splitInput = userInput.split(SPLIT_CRITERIA);
        List<Integer> result = new ArrayList<>();

        for (String eachInput : splitInput) {
            result.add(validate(eachInput));
        }
        return result;
    }

    private int validate(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoErrorMessage.SEPARATE_ONLY_COMMA.getMessage());
        }
    }
}
