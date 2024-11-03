package lotto.domain.service;

import lotto.domain.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerationService {
    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
