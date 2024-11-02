package lotto.domain;

import static lotto.domain.LottoInfo.END_NUMBER;
import static lotto.domain.LottoInfo.PICK_COUNT;
import static lotto.domain.LottoInfo.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoNumbersGenerator {

    public static List<Integer> generate() {
        List<Integer> mutableNumbers = new ArrayList<>( Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT));
        mutableNumbers.sort(Comparator.naturalOrder());
        return mutableNumbers;
    }
}
