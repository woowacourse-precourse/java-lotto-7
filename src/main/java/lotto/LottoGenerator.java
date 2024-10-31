package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator implements NumberInRangeGenerator {

    @Override
    public List<Integer> randomGenerate(int start, int end, int cnt) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, cnt);
        Collections.sort(numbers);
        return numbers;
    }
}
