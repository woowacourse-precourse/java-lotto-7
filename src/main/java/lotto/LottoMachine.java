package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_BEGIN = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> drawResults(int budget) {
        int numberOfLotto = numberOfLotto(budget);
        List<Lotto> lottoResults = new ArrayList<>(numberOfLotto);

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_NUMBER_BEGIN,
                    LOTTO_NUMBER_END,
                    LOTTO_NUMBER_COUNT
            );
            Lotto lotto = new Lotto(numbers);
            lottoResults.add(lotto);
        }
        return lottoResults;
    }

    private static int numberOfLotto(int budget) {
        return budget / LOTTO_PRICE;
    }
}
