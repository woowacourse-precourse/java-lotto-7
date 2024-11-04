package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int UNIT = 1000;

    public List<Lotto> makeLottoNumbers(int price) {

        ValidationException.validatePrice(price);

        int count = price / UNIT;
        List<Lotto> tryLotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tryLotto.add(generateLotto());
        }

        return tryLotto;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
