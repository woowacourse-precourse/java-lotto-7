package lotto.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.service.port.RandomHolder;

public class LottoRandomHolder implements RandomHolder {

    @Override
    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
