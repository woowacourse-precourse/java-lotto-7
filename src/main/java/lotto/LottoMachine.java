package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public List<List<Integer>> issue(int lottoPurchaseAmount) {
        int lottoCount = calculateLottoCount(lottoPurchaseAmount);
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = sortLottoNumbers(generateLottoNumbers());
            lottos.add(lotto);
        }

        return lottos;
    }

    private int calculateLottoCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> sortLottoNumbers(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }
}