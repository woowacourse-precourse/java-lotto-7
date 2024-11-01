package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import common.LottoNumber;
import java.util.List;

public class LottoGenerator {

    public Lotto random() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.START.getNumber(),
                LottoNumber.END.getNumber(),
                LottoNumber.SIZE.getNumber()
        );
        return new Lotto(numbers);
    }
}
