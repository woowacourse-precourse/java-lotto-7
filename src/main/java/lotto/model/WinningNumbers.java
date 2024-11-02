package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.validate.Validator.validateWinning;

public class WinningNumbers {
    private final Lotto winningLotto;

    public WinningNumbers(String line){
        validateWinning(line);
        this.winningLotto = new Lotto(lineToNumbers(line));
    }

    private static List<Integer> lineToNumbers(String line) {
        String[] splitLine = line.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : splitLine) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

}
