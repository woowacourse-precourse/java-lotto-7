package lotto.service;

import static lotto.view.InputView.inputWinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class ParsingWinningNumberService {
    private static final String DELIMITER = ",\\s*";

    public static Lotto parseWinningNumbers(String inputWinningNumber) {
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumber.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
        return new Lotto(winningNumbers);
    }
}
