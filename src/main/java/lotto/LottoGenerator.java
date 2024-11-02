package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int NUMBERS_PER_LOTTO = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int PRICE_OF_LOTTO = 1000;

    public List<Lotto> generate(long payment) {
        long lottoCount = payment / PRICE_OF_LOTTO;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBERS_PER_LOTTO);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
