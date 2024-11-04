package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class LottoNumbersInputParser {
    private static final String DELIMITER = ",";

    public List<Integer> parse(String input) {
        String[] lottoNumbers = input.split(",");

        return mapInteger(lottoNumbers);
    }

    private List<Integer> mapInteger(String[] lottoNumbers) {
        try {
            return Arrays.stream(lottoNumbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 정수여야 합니다.");
        }
    }
}
