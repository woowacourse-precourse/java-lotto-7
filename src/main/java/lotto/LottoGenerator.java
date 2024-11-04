package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUM_SIZE = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;

    public List<Lotto> lottoGenerator(int lottoAmount) {
        List<Lotto> generatedLotto = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> generatedNumbers = generateNumbers();
            generatedLotto.add(new Lotto(generatedNumbers));
        }

        return generatedLotto;
    }
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUM_SIZE);
    }
}
