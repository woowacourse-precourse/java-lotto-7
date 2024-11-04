package lotto.parser;

import java.util.List;

public class LottoNumbersInputParser {
    private static final String DELIMITER = ",";

    public List<String> parseInput(String input) {
        String[] lottoNumbers = input.split(",");

        return List.of(lottoNumbers);
    }
}
