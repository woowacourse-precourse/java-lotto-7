package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    public List<Lotto> purchaseLotto (int lottoPurchaseCount) {
        List<Lotto> purchaseLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++) {
            purchaseLottoNumbers.add(
                    new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return purchaseLottoNumbers;
    }


}
