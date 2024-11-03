package lotto.model.draw;

import java.util.Arrays;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    public LottoNumbers(final String lottoNumbers) {
        // TODO validate(lottoNumbers);
        List<String> lottoNumbersSplit = Arrays.asList(lottoNumbers.split(","));
        this.lottoNumbers = lottoNumbersSplit.stream().map(String::strip).map(Integer::parseInt).toList();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
