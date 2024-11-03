package lotto.utilities;

import java.util.LinkedList;
import java.util.List;
import lotto.enums.ErrorMessage;

public class Parser {
    public static Integer parseNumberToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INT_NUMBER.getMessage());
        }
    }

    public static List<Integer> parseNumbersToInt(List<String> numbers) {
        List<Integer> intNumbers = new LinkedList<Integer>();
        for (String number : numbers) {
              try {
                  intNumbers.add(Integer.parseInt(number));
              } catch (NumberFormatException e) {
                  throw new IllegalArgumentException(ErrorMessage.INVALID_INT_NUMBER.getMessage());
              }
        }
        return intNumbers;
    }
}
