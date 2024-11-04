package lotto.io;

import java.util.ArrayList;
import java.util.List;
import lotto.validation.InputValidation;

public class InputUtils {
    InputValidation validation = new InputValidation();

    public List<String> splitByComma(String input) {
        return new ArrayList<>(List.of(input.split(",")));
    }

    public List<Integer> toIntegerList(List<String> input) {
        List<Integer> result = new ArrayList<>();
        validation.convertValid(input);
        for (String s : input) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
