package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> purchaseLottoes(final PurchaseAmount purchaseAmount) {
        int totalLottoCount = purchaseAmount.calculateTotalLottoCount();
        return issueLottoes(totalLottoCount);
    }

    private static List<Lotto> issueLottoes(int totalLottoCount) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < totalLottoCount; i++) {
            lottoes.add(new Lotto(generateLottoNumbers()));
        }
        return lottoes;
    }

    private static List<Integer> generateLottoNumbers() {
        return pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
    }
}