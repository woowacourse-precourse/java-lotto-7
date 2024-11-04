package lotto.Random;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

import static lotto.enums.LottoConstants.*;

public class RandomLottoNumberGenerator implements RandomGenerator{

    @Override
    public List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }
}
