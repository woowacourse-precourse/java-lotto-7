package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class LottoGenerator {

    static final Integer LOTTO_NUMBER_START = 1;
    static final Integer LOTTO_NUMBER_END = 45;
    static final Integer LOTTO_NUMBER_COUNT = 6;

    public LottoGenerator() {
    }

    public Lotto lottoGenrate() {
        var lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START,
                LOTTO_NUMBER_END,
                LOTTO_NUMBER_COUNT
        ));


        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
