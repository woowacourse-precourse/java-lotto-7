package lotto.converter;

import java.util.ArrayList;
import java.util.List;
import lotto.util.ErrorMessage;

public class StringToIntConverter {

    public static final String DELIMITER = ",";

    public int convertStringNumberToInteger(String rawNum) {
        try {
            return Integer.parseInt(rawNum.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMsg());
        }
    }

    public List<Integer> convertStringNumbersToIntegers(String rawNums) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String rawNumber : rawNums.split(DELIMITER)) {
                numbers.add(convertStringNumberToInteger(rawNumber));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMsg());
        }
        return numbers;
    }
}
