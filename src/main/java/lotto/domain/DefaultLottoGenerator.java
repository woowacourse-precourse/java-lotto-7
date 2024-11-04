package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class DefaultLottoGenerator implements LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    @Override
    public Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = generateRandomNumber();
            lottos.add(new Lotto(randomNumbers));
            OutputView.printLottoNumbers(randomNumbers);
        }
        return new Lottos(lottos);
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_SIZE);
    }
}
