package lotto.lottoMachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottos(Integer purchaseNumber) {
        List<Lotto> userLottos = new ArrayList<>();
        for(int i = 0; i < purchaseNumber; i++) {
            userLottos.add(generateLotto());
        }
        return userLottos;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
