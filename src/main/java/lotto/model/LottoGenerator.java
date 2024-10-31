package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    private final List<Lotto> lottoList;

    public LottoGenerator(int purchaseAmount) {
        lottoList = new ArrayList<>();
        generateLottoList(purchaseAmount);
    }

    private void generateLottoList(int purchaseAmount) {
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(lottoNumbers));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
