package lotto.domain.extractor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoExtractor {

    private static final String DELIMITER = ",";

    public List<Integer> extractLotto(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
