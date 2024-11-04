package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    static final int SIZE_OF_LOTTO = 6;
    static final int MIN_LOTTO_NUMBER = 1;
    static final int MAX_LOTTO_NUMBER = 45;

    PrintManager printManager = new PrintManager();

    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public void pickSortedLotto(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> oneRowLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, SIZE_OF_LOTTO));
            Collections.sort(oneRowLotto);
            Lotto lotto = new Lotto(oneRowLotto);
            this.purchasedLotto.add(lotto);
        }
    }

    public void printPurchasedLotto(int numberOfLotto) {
        printManager.printLottoNumbers(numberOfLotto, getpurchasedLotto());
    }

    public List<Lotto> getpurchasedLotto() {
        return this.purchasedLotto;
    }
}
