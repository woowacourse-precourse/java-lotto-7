package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoConstants.LOTTO_PRICE_UNIT;

public class LottoGenerator {
    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;
    private static final int LOTTO_NUMBER_LENGTH = 6;
    public static List<Lotto> generateLottoWallet(long purchasePrice) {
        int ea = (int) (purchasePrice / LOTTO_PRICE_UNIT);
        List<Lotto> wallet = new ArrayList<>();
        for (int i = 0; i < ea; i++) {
            List<Integer> lottoContent = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMBER_LENGTH)
                    .stream()
                    .sorted()
                    .toList();
            wallet.add(new Lotto(lottoContent));
        }
        return wallet;
    }
}
