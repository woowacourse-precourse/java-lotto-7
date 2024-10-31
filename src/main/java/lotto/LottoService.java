package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;

public class LottoService {

    public Lotto makeLotto() {
        List<Integer> pickedUniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(pickedUniqueNumbers);
    }

}
