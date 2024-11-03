package lotto.validator;

import java.util.Arrays;
import java.util.List;

public class ListInputValidator extends InputValidator<List<Integer>>{
    @Override
    protected List<Integer> parse(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
