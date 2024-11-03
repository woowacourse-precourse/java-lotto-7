package lotto.model;

import static lotto.constants.GlobalLottoConst.UNIT;

import java.util.ArrayList;
import java.util.List;
import lotto.util.random.LottoNumberGenerator;

public class LottoStore {

    public static LottoTicket purchaseLottoTicket(int purchaseAmount) {
        int lottoCount = getLottoCount(purchaseAmount);
        return createLottoTicket(lottoCount, purchaseAmount);
    }

    private static int getLottoCount(int purchaseAmount) {
        return purchaseAmount / UNIT;
    }

    private static LottoTicket createLottoTicket(int lottoCount, int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = LottoNumberGenerator.getLottoNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }

        return new LottoTicket(lottos, purchaseAmount);
    }
}
