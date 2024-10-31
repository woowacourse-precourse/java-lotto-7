package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_BEGIN = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> generateLotto(int budget) {
        int numberOfLottos = budget / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>(numberOfLottos);

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_NUMBER_BEGIN,
                    LOTTO_NUMBER_END,
                    LOTTO_NUMBER_COUNT
            );
            lottos.add(new Lotto(generatedNumbers));
        }
        return lottos;
    }
}
