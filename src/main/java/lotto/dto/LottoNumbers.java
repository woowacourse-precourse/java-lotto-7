package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
