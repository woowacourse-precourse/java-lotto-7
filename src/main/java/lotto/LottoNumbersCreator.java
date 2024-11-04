package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersCreator {
    public static List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoInfo.FIRST_NUMBER.getInfo(), LottoInfo.LAST_NUMBER.getInfo(),
                LottoInfo.NUMBER_COUNT.getInfo());
    }
}
