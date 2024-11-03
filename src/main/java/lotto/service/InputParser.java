package lotto.service;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public InputParser() {
    }

    public List<String> parseWithComma(String input) {
        String[] tokens = input.split(",");
        return Arrays.asList(tokens);
    }

}
