package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class TempLottos {
    private final List<int[]> lottoNumbers = new ArrayList<int[]>();

    public TempLottos(int[] lottoNumber) {
        this.lottoNumbers.add(lottoNumber);
    }

    public List<int[]> getLottoNumbers() {
        return lottoNumbers;
    }
}
