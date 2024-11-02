package lotto.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberParser {
    private static final String SEPARATOR = ",";
    public List<Integer> parseWinningNumber(String input){

        List<String> separatedInput = separateInput(input);
        return separatedInput.stream()
            .map(this::trimElement)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private List<String> separateInput(String input){
        return new ArrayList<>(Arrays.asList(input.split(SEPARATOR)));
    }

    private String trimElement(String element){
        return element.trim();
    }
}
