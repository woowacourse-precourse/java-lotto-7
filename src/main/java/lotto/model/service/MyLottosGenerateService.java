package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;

public class MyLottosGenerateService {

    public List<Lotto> generateLottos(int amount) {
        int countOfGenerate = amount / 1000;
        List<Lotto> myLottos = new ArrayList<>();
        for (int count = 0; count < countOfGenerate; count++) {
            myLottos.add(generateLotto());
        }
        return myLottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_LENGTH));
    }
}
