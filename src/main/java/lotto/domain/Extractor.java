package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Extractor {

    private static final String DELIMITER = ",";

    public Extractor() {}

    public List<Integer> extractLottoNumber(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(Validator::validateLottoNumber).toList();
    }
}
