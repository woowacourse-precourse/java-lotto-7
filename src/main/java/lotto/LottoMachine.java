package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<lotto.Lotto> generatedLottos = new ArrayList<>();

    public List<lotto.Lotto> generateLotto(int quantity) {
        for (int count = 0; count < quantity; count++) {
            generatedLottos.add(new lotto.Lotto(getRandomLottoNumbers()));
        }
        return generatedLottos;
    }

    private List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoRules.MIN_NUMBER, LottoRules.MAX_NUMBER,
                LottoRules.NUMBERS_REQUIRED);
    }
}


