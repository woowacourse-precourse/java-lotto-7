package lotto.domain;

import static lotto.domain.Constant.MINIMUM_LOTTO_NUMBER;
import static lotto.domain.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.Constant.LOTTO_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_LENGTH);
        Lotto lotto = null;

        try{
            lotto = new Lotto(numbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return generate();
        }

        return lotto;
    }
}
