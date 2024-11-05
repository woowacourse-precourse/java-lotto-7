package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class TempLottos {
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public void add(List<Integer> lottoNumber) {
        this.lottoNumbers.add(lottoNumber);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }
}
