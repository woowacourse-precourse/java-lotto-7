package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoGameConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoGameConfig.START_NUMBER,
                LottoGameConfig.END_NUMBER,
                LottoGameConfig.COUNT
        );
        ArrayList<Integer> returnNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(returnNumbers);
        return returnNumbers;
    }

}
