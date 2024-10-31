package lotto.view;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int readPrice() {
        String input = readConsole().trim();
        InputValidator.validateInput(input);
        return Integer.parseInt(input);
    }

    public List<Integer> readWinningNumbers() {
        String input = readConsole().trim();
        List<String> stringList = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
        InputValidator.validateWinningNumbers(stringList);
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String readConsole() {
        return readLine();
    }
}
