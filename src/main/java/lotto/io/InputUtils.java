package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessageConstants;

public class InputUtils {

    public List<String> splitByComma(String input) {
        return new ArrayList<>(List.of(input.split(",")));
    }

    public List<Integer> toIntegerList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessageConstants.VALUE_IS_NOT_NUMBER);
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}
