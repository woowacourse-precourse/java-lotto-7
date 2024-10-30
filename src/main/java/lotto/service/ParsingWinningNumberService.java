package lotto.service;

import java.util.Arrays;
import java.util.List;
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