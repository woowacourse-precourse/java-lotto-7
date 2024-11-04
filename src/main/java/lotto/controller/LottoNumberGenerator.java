package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Constants.*;

public class LottoNumberGenerator {
    public static List<Integer> generate() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        LOTTO_STARTING_RANGE.getValue(),
                        LOTTO_END_RANGE.getValue(),
                        LOTTO_COUNT.getValue()
                )
        );
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
