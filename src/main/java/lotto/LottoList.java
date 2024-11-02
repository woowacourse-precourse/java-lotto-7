package lotto;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private static final int lottoNumberCount = 6;
    private static final int lottoNumberMin = 1;
    private static final int lottoNumberMax = 45;
    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoList(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            this.lottoList.add(new Lotto(pickUniqueNumbersInRange(lottoNumberMin, lottoNumberMax, lottoNumberCount)));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
