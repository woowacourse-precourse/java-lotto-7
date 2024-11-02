package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.random.RandomNumberUtils;

public class LottoStore {

    private static final int UNIT = 1000;

    public static LottoTicket purchaseLottoTicket(int purchaseAmount) {

        int lottoCount = getLottoCount(purchaseAmount);
        return createLottoTicket(lottoCount);

    }

    private static int getLottoCount(int purchaseAmount) {
        return purchaseAmount / UNIT;
    }

    private static LottoTicket createLottoTicket(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = RandomNumberUtils.getLottoNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        return new LottoTicket(lottos);
    }
}
